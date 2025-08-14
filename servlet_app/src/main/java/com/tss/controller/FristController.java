package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FristController")
public class FristController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FristController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String firstName = request.getParameter("firstname");
		
//		Cookie cookie = new Cookie("firstname",firstName);
//		response.addCookie(cookie);
		
		HttpSession session = request.getSession();
		session.setAttribute("firstname", firstName);
		
		writer.print("<html> <body>");
		writer.print("<form action = 'SecondController' method = 'post'> ");
		writer.print("LastName : <input type='text' , name = 'lastname' ></input>");
		writer.print("<button>Next</button><br><br>");
		writer.print("</form>");
		writer.print("</body></html>");
		
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
