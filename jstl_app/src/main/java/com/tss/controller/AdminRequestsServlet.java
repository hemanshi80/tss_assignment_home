package com.tss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.dao.LeaveRequestDao;
import com.tss.model.Admin;
import com.tss.model.LeaveRequest;

@WebServlet("/admin/requests")
public class AdminRequestsServlet extends HttpServlet {
    private final LeaveRequestDao leaveDao = new LeaveRequestDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if (admin == null) {
        	resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        try {
            // leaveDao will fetch empId from DB itself
            List<LeaveRequest> requests = leaveDao.findAllPending();
            req.setAttribute("requests", requests);
            req.getRequestDispatcher("/requests.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Error fetching leave requests", e);
        }
    }
}
