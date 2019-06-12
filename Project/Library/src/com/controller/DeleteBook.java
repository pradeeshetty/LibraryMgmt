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
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBook() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String bookid = request.getParameter("bookid");
		 DbConnection d=new DbConnection();
		 int i=d.deletebook(bookid);
		 if(i!=0)
		 {
			  out.println("<script type=\"text/javascript\">");
			  out.println("alert('Book Deleted successfully');");
			  out.println("location='deletebook.jsp';");
			  out.println("</script>");
		 }
		 else
		 {
			  out.println("<script type=\"text/javascript\">");
			  out.println("alert('Book has been issued or requested by someone cannot delete now');");
			  out.println("location='deletebook.jsp';");
			  out.println("</script>");
		 }
	}

}
