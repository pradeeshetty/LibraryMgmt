package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnection.DbConnection;
import com.model.AddBook;

/**
 * Servlet implementation class AddBooks
 */
@WebServlet("/AddBooks")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooks() {
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
		PrintWriter out=response.getWriter();
		 String bookname = request.getParameter("bookname");
		 String author = request.getParameter("author");
		 String publisher = request.getParameter("publisher");
		 String price = request.getParameter("price");
		 String pages = request.getParameter("pages");
		 String year = request.getParameter("year");
		 String copies = request.getParameter("copies");
		 AddBook ad=new AddBook();
		 ad.setBookname(bookname);
		 ad.setAuthor(author);
		 ad.setAvailability(copies);
		 ad.setCopies(copies);
		 ad.setYear(year);
		 ad.setPages(pages);
		 ad.setPublisher(publisher);
		 ad.setPrice(price);
		 DbConnection d=new DbConnection();
	//	 int i=d.addbook(ad);
		 int i=d.DuplicateBooks(ad);
		 if(i==2)
		 {
			 out.println("<script type=\"text/javascript\">");
			  out.println("alert('Book already exist incremented copies and available');");
			  out.println("location='addbooks.jsp';");
			  out.println("</script>");
		 }
		 else if(i==1)
		 {
			 out.println("<script type=\"text/javascript\">");
			  out.println("alert('Book Added successfully');");
			  out.println("location='addbooks.jsp';");
			  out.println("</script>");
		 }
		 else
		 {
			 out.println("<script type=\"text/javascript\">");
			  out.println("alert('Failed to add try again');");
			  out.println("location='addbooks.jsp';");
			  out.println("</script>");
		 }
	}

}
