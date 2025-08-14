//package com.tss.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/LoginController")
//public class LoginController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//  
//    public LoginController() {
//        super();
//      
//    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		
//		 PrintWriter writer = response.getWriter();
//		 
//		 String name = request.getParameter("name");
//	        String address = request.getParameter("address");
//	        String gender = request.getParameter("gender");
//	        String city = request.getParameter("city");
//	        String[] languages = request.getParameterValues("languages");
//	        String username = request.getParameter("username");
//	        String password = request.getParameter("password");
//	        String confirmPassword = request.getParameter("confirmPassword");
//	        
//	        writer.println("<h2>Registration Details</h2>");
//	        writer.println("Name: <b>" + name + "</b><br><br>");
//	        writer.println("Address: <b>" + address + "</b><br><br>");
//	        writer.println("Gender: <b>" + gender + "</b><br><br>");
//	        writer.println("City: <b>" + city + "</b><br><br>");
//	        
//	        writer.print("Languages Known: <b>");
//	        if (languages != null) {
//	            for (String lang : languages) {
//	                writer.print(lang + " ");
//	            }
//	        } else {
//	            writer.print("None");
//	        }
//	        writer.println("</b><br><br>");
//	        
//	        writer.println("Username: <b>" + username + "</b><br><br>");
////	        writer.println("Password: <b>" + password + "</b><br><br>");
////	        writer.println("Confirm Password: <b>" + confirmPassword + "</b><br><br>");
////	        
//	        if (!password.equals(confirmPassword)) {
//	            writer.println("<p style='color:red;'> Password and Confirm Password do not match!</p>");
//	        } else {
//	            writer.println("<p style='color:green;'> Registration successful!</p>");
//	        }
//	}
//
//}
