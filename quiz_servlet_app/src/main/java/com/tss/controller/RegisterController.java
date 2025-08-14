package com.tss.controller;

import com.tss.model.User;
import com.tss.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(username, password, email);
        boolean isRegistered = userService.register(user);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (isRegistered) {
           
            response.sendRedirect("login.html?success=true");
        } else {
           
            response.setContentType("text/html");
            response.getWriter().println("<h3 style='color:red;'>Registration failed. Try again.</h3>");
            response.getWriter().println("<a href='register.html'>Back to Register</a>");
        }
    }
}
