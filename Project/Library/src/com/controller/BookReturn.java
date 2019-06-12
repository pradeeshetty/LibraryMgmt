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
 * Servlet implementation class BookReturn
 */
@WebServlet("/BookReturn")
public class BookReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReturn() {
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
		String issueid=request.getParameter("issueid");
		String bookid=request.getParameter("bookid");
		
		System.out.println("issue id "+issueid+"book id "+bookid);
		/*
		 * AddRequest ar=new AddRequest(); ar.setBookid(bookid); ar.setUserid(userid);
		 */
		
		DbConnection d=new DbConnection();
		//increase available
		d.increaseavailable(bookid);
		//delete record from issued table
		int issued=d.deleteissued(bookid,issueid);
		if(issued!=0)
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Return Successfully');");
			   out.println("location='issuedbooks.jsp';");
			   out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Failed to Return');");
			   out.println("location='issuedbooks.jsp';");
			   out.println("</script>");
		}
	}

}
