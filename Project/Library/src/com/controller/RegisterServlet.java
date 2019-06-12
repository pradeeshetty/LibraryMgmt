package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnection.DbConnection;
import com.model.Register;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		PrintWriter out=response.getWriter();
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String contact = request.getParameter("contact");
		 String password = request.getParameter("pass");
		
		 Register registerBean = new Register();
	
		 registerBean.setName(name);
		 registerBean.setEmail(email);
		 registerBean.setContact(contact);
		 registerBean.setPassword(password); 
		 DbConnection d=new DbConnection();
		 boolean emailexist=false;
		 emailexist=d.emailexist(email);
		
		 if(!emailexist)
		 {
			 
			 d.registerUser(registerBean);
			 out.println("<script type=\"text/javascript\">");
			  out.println("alert('Registered Successfully');");
			  out.println("location='login.jsp';"); 
			  out.println("</script>");
		 //request.getRequestDispatcher("/login.jsp").forward(request, response);
		 }
		 else  
				
				  { 
			 out.println("<script type=\"text/javascript\">");
			  out.println("alert('Email already exist');");
			  out.println("location='register.jsp';"); 
			  out.println("</script>");
				  }
				 
			
		
			 
		// request.getRequestDispatcher("/register.jsp").forward(request, response);
		 }
	
		
		
	}

