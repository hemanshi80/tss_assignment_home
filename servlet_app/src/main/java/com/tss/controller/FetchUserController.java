package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.db.UserDatabase;
import com.tss.model.User;
import com.tss.service.ReadUserService;

@WebServlet("/FetchUserController")
public class FetchUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReadUserService userService = new ReadUserService();

    public FetchUserController() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Connection connection = UserDatabase.connect();
        List<User> users = userService.fetchAllUsers(connection);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Registered Users</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>Username</th><th>Password</th></tr>");

        for (User user : users) {
            out.println("<tr><td>" + user.getUserName() + "</td><td>" + user.getPassword() + "</td></tr>");
        }

        out.println("</table>");
//        out.println("<br><a href='index.html'>Go Back</a>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}