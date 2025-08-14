package com.tss.controller;

import com.tss.model.User;
import com.tss.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username, password);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (user != null) {
            // Store user in session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("quiz"); // redirect to first quiz page
        } else {
            out.println("<h3>Invalid Credentials. Please try again.</h3>");
        }
    }
}