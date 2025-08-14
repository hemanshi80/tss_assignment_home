package com.tss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.model.Admin;
import com.tss.service.AdminService;

@WebServlet("/admin/decision")
public class AdminDecisionServlet extends HttpServlet {
    private final AdminService adminService = new AdminService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        if (admin == null) {
            resp.sendRedirect(req.getContextPath() + "/admin/login");
            return;
        }

        String action = req.getParameter("action"); // approve or reject
        int requestId = Integer.parseInt(req.getParameter("requestId"));

        String message;
        if ("approve".equalsIgnoreCase(action)) {
            // pass adminId fetched from session object (from DB during login)
            message = adminService.approve(requestId, admin.getAdminId());
        } else if ("reject".equalsIgnoreCase(action)) {
            message = adminService.reject(requestId, admin.getAdminId());
        } else {
            message = "Invalid action";
        }

        req.getSession().setAttribute("flash", message);
        resp.sendRedirect(req.getContextPath() + "/admin/requests");
    }
}
