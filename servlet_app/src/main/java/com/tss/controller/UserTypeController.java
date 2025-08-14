package com.tss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserTypeController")
public class UserTypeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
    public UserTypeController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType = request.getParameter("userType");
         String userName = request.getParameter("userName");

          request.setAttribute("userName", userName);


        RequestDispatcher dispatcher;

        if ("customer".equalsIgnoreCase(userType)) {
            dispatcher = request.getRequestDispatcher("CustomerController");
        } else if ("admin".equalsIgnoreCase(userType)) {
            dispatcher = request.getRequestDispatcher("AdminController");
        } else {
            response.sendRedirect("error.html");
            return;
        }

        dispatcher.forward(request, response);    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}