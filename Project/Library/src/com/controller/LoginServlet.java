package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DbConnection.DbConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		boolean isValidLogin = false;
		PrintWriter out=response.getWriter();
		 String email = request.getParameter("email");

		 String password = request.getParameter("pass");
		 String role=request.getParameter("role");
		 System.out.println("role "+role);
		 System.out.println("email and pass "+email+" "+password);
		 
		 if(role.equals("Admin") && email.equals("admin") && password.equals("admin"))
		 {
			 HttpSession session = request.getSession(true);
			 	session.setAttribute("admin", "admin");
			 request.getRequestDispatcher("/admin.jsp").forward(request, response);
		 }
		 DbConnection d=new DbConnection();
		 
 		 isValidLogin = d.login(email,password);
 		
		// System.out.println("User Reg "+userRegistered);
 		
		 if(isValidLogin && role.equals("User"))  
		 {
			 	HttpSession session = request.getSession(true);
			 	session.setAttribute("user", email);
			 	request.getRequestDispatcher("/userhome.jsp").forward(request, response);
		 
		 }
		
		 else  
		 {
		
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Email or Password incorrect');");
			   out.println("location='login.jsp';");
			   out.println("</script>");
		 }
	}

}
