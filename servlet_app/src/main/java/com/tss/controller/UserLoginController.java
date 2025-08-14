package com.tss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.service.UserLoginService;

@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserLoginService userService = new UserLoginService();
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String theme = request.getParameter("theme");
        
        boolean valid = userService.isValidUser(username, password, role);
        
        if (valid) {
            // Pass data to target servlet
        	request.setAttribute("username", username);
        	request.setAttribute("role", role);
        	request.setAttribute("theme", theme);

            RequestDispatcher rd;
            if ("Admin".equalsIgnoreCase(role)) {
                rd = request.getRequestDispatcher("UserAdminController");
            } else {
                rd = request.getRequestDispatcher("UserCustomerController");
            }
            rd.forward(request, response);

        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h3 style='color:red;'>Invalid Credentials. Please check your role, username, or password.</h3>");
        }
    }

}
