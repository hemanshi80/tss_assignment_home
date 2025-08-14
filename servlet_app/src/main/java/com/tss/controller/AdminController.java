package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public AdminController() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
           String name = (String) request.getAttribute("userName");

            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<h2>Welcome, Admin " + name + "!</h2>");}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        doGet(request, response);
    }

}