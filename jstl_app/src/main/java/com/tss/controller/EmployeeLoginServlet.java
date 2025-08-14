package com.tss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tss.dao.EmployeeDao;
import com.tss.model.Employee;

@WebServlet("/employee/login")
public class EmployeeLoginServlet extends HttpServlet {
    private final EmployeeDao empDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employee/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("empName");

        try {
            Employee emp = empDao.login(name);
            if (emp != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("employee", emp);
                resp.sendRedirect(req.getContextPath() + "/employee/dashboard");
            } else {
                req.setAttribute("error", "Employee not found");
                req.getRequestDispatcher("/employee/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException("Error during employee login", e);
        }
    }
}
