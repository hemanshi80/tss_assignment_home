package com.tss.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.service.AdminService;


@WebServlet("/leaveAction")
public class LeaveActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = new AdminService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        int requestId = Integer.parseInt(request.getParameter("requestId"));

        boolean result = false;
        if ("approve".equalsIgnoreCase(action)) {
            result = adminService.approveLeave(requestId);
        } else if ("reject".equalsIgnoreCase(action)) {
            result = adminService.rejectLeave(requestId);
        }

        if (result) {
            request.setAttribute("message", "Leave request " + action + "d successfully");
        } else {
            request.setAttribute("error", "Failed to update leave status");
        }

        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}
