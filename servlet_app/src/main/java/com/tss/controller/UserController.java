package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tss.db.UserDatabase;
import com.tss.model.User;
import com.tss.service.UserService;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private Connection connection;
	private UserService userService;
	
    public UserController() {
        super();
    connection = UserDatabase.connect();
    userService = new UserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(connection);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username ,password);
		if( userService.addNewUser(connection, user)){
			PrintWriter writer = response.getWriter();
			writer.println("User Added Successfully in DB");
		}
		else {
			System.out.println("Error in Adding Data to DB");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
