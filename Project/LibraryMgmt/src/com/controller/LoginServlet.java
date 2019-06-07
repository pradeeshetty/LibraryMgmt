package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		boolean isValidLogon = false;
		PrintWriter out=response.getWriter();
		 String email = request.getParameter("email");

		 String password = request.getParameter("pass");
		 DbConnection d=new DbConnection();
		 
 		 isValidLogon = d.login(email,password);
 		
		// System.out.println("User Reg "+userRegistered);
		 if(isValidLogon)  
		 {
		 request.getRequestDispatcher("/userhome.jsp").forward(request, response);
		 }
		 else  
		 {
		 //request.setAttribute("errMessage", userRegistered);
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Email or Password incorrect');");
			   out.println("location='login.jsp';");
			   out.println("</script>");
		 }
	}

}
