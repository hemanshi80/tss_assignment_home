package com.tss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondController
 */
@WebServlet("/SecondController")
public class SecondController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String firstname = "";
		if (session != null && session.getAttribute("firstname") != null) {
			firstname = (String) session.getAttribute("firstname");
		}

//		Cookie cookies[] = request.getCookies();
//		
//		if(cookies != null) {
//		for (Cookie cookie:cookies) {
//			if("firstname".equals(cookie.getName()));
//			firstname = cookie.getValue();
//			break;
//			
//		}
//		}
		
		String lastname = request.getParameter("lastname");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><body>");
		writer.print("<h2> FirstName :"+ firstname+"</h2>");
		writer.print("<h2> LastName  :"+ lastname+"</h2>");
		writer.print("</body></html>");
		
		writer.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
