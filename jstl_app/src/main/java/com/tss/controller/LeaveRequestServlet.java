package com.tss.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.dao.EmployeeDao;
import com.tss.dao.LeaveRequestDao;
import com.tss.db.DBConnection;
import com.tss.model.Employee;
import com.tss.model.LeaveRequest;

@WebServlet("/employee/request-leave")
public class LeaveRequestServlet extends HttpServlet {
    private final LeaveRequestDao leaveDao = new LeaveRequestDao();
    private final EmployeeDao empDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("employee") == null) {
            resp.sendRedirect(req.getContextPath() + "/employee/login");
            return;
        }

        req.getRequestDispatcher("/employee/request-leave.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("employee") == null) {
            resp.sendRedirect(req.getContextPath() + "/employee/login");
            return;
        }

        Employee emp = (Employee) session.getAttribute("employee");

        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
        String leaveType = req.getParameter("leaveType");  // PLANNED / UNPLANNED
        String duration = req.getParameter("duration");    // FULL / HALF_UPPER / HALF_LOWER
        String reason = req.getParameter("reason");

        // calculate number of days
        double days = (double) (endDate.toEpochDay() - startDate.toEpochDay() + 1);
        if (!duration.equalsIgnoreCase("FULL")) {
            days = 0.5;
        }

        LeaveRequest lr = new LeaveRequest();
        lr.setEmpId(emp.getEmpId());
        lr.setStartDate(startDate);
        lr.setEndDate(endDate);
        lr.setLeaveType(leaveType);
        lr.setDuration(duration);
        lr.setReason(reason);
        lr.setNumberOfDays(days);
        lr.setStatus("PENDING");

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // check leave balance
            double[] balances = empDao.lockAndGetBalances(con, emp.getEmpId());
            if (balances == null) {
                con.rollback();
                req.setAttribute("error", "Employee not found.");
                req.getRequestDispatcher("/employee/request-leave.jsp").forward(req, resp);
                return;
            }

            double available = leaveType.equalsIgnoreCase("PLANNED") ? balances[0] : balances[1];
            if (available < days) {
                con.rollback();
                req.setAttribute("error", "Insufficient " + leaveType.toLowerCase() + " leave balance.");
                req.getRequestDispatcher("/employee/request-leave.jsp").forward(req, resp);
                return;
            }

            // insert leave request
            leaveDao.addLeaveRequest(con, lr);

            con.commit();
            resp.sendRedirect(req.getContextPath() + "/employee/dashboard");
        } catch (SQLException e) {
            throw new ServletException("Error submitting leave request", e);
        }
    }
}
