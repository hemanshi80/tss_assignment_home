package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserCustomerController
 */
@WebServlet("/UserCustomerController")
public class UserCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = (String) request.getAttribute("username");
	        String role = (String) request.getAttribute("role");
	        String theme = (String) request.getAttribute("theme");

	        String bgColor = theme.equalsIgnoreCase("green") ? "#ccffcc" : "#cce6ff";

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html><body style='background-color:" + bgColor + ";'>");
	        out.println("<h2>Good Morning, " + username + " (Customer)</h2>");
	        out.println("</body></html>");
	}

}
