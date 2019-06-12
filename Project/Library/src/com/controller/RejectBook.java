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
 * Servlet implementation class RejectBook
 */
@WebServlet("/RejectBook")
public class RejectBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String bookid=request.getParameter("bookid");
		String reqid=request.getParameter("requestid");
		DbConnection d=new DbConnection();
		int i=d.rejectrequest(bookid,reqid);
		System.out.println("i "+i);
		if(i!=0)
		{
			out.println("<script type=\"text/javascript\">");
			  out.println("alert('Rejected successfully');");
			  out.println("location='bookrequest.jsp';");
			  out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			  out.println("alert('Failed to reject');");
			  out.println("location='bookrequest.jsp';");
			  out.println("</script>");
		}
	}

}
