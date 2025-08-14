package com.tss.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.dao.LeaveRequestDao;
import com.tss.db.DBConnection;
import com.tss.model.Employee;

@WebServlet("/employee/cancel-leave")
public class CancelLeaveServlet extends HttpServlet {
    private final LeaveRequestDao leaveDao = new LeaveRequestDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("employee") == null) {
            resp.sendRedirect(req.getContextPath() + "/employee/login");
            return;
        }

        Employee emp = (Employee) session.getAttribute("employee");
        int requestId = Integer.parseInt(req.getParameter("requestId"));

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // mark leave as CANCELLED_BY_EMPLOYEE
            boolean ok = leaveDao.cancelByEmployee(con, requestId, emp.getEmpId());
            if (!ok) {
                con.rollback();
                req.setAttribute("error", "Cannot cancel this leave.");
            } else {
                con.commit();
            }

            resp.sendRedirect(req.getContextPath() + "/employee/dashboard");
        } catch (SQLException e) {
            throw new ServletException("Error cancelling leave request", e);
        }
    }
}
