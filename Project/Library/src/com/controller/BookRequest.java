package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbConnection.DbConnection;
import com.model.AddRequest;

/**
 * Servlet implementation class BookRequest
 */
@WebServlet("/BookRequest")
public class BookRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRequest() {
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
		String userid=request.getParameter("userid");
		String bookid=request.getParameter("bookid");
		
		System.out.println("user id "+userid+"book id "+bookid);
		AddRequest ar=new AddRequest();
		DbConnection d=new DbConnection();
		ar.setBookid(bookid);
		ar.setUserid(userid);
		int r=d.addrequest(ar);
		 if(r==1)
		 {
			 out.println("<script type=\"text/javascript\">");
			  out.println("alert('Request sent successfully');");
			  out.println("location='userbooks.jsp';");
			  out.println("</script>");
		 }
		 else
		 {
			 out.println("<script type=\"text/javascript\">");
			  out.println("alert('Failed to send again');");
			  out.println("location='addbooks.jsp';");
			  out.println("</script>");
		 }
	}

}
