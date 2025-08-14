package com.tss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.dao.LeaveRequestDao;
import com.tss.model.Employee;
import com.tss.model.LeaveRequest;

@WebServlet("/employee/dashboard")
public class EmployeeDashboardServlet extends HttpServlet {
    private final LeaveRequestDao leaveDao = new LeaveRequestDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("employee") == null) {
            resp.sendRedirect(req.getContextPath() + "/employee/login");
            return;
        }

        Employee emp = (Employee) session.getAttribute("employee");

        try {
            List<LeaveRequest> requests = leaveDao.findByEmployee(emp.getEmpId());
            req.setAttribute("leaveRequests", requests);
            req.setAttribute("employee", emp);
            req.getRequestDispatcher("/employee/dashboard.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Error loading dashboard", e);
        }
    }
}
