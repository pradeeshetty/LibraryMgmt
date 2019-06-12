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
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBook() {
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
	//	doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		AddRequest ar=new AddRequest();
		String bookid=request.getParameter("bookid");
		String userid=request.getParameter("userid");
		String reqid=request.getParameter("requestid");
		System.out.println("user id "+userid);
		DbConnection d=new DbConnection();
		ar.setBookid(bookid);
		ar.setUserid(userid);
		
		d.addmsg(ar);
		int available=d.getavailable(bookid);
		//System.out.println("i "+i);
			if(available>0)
			{
				d.updatavailable(bookid);
				d.addissuedbooks(ar);
				d.rejectrequest(bookid, reqid);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Book issued for the user successfully');");
				out.println("location='bookrequest.jsp';");
				out.println("</script>");
			}
				//d.rejectrequest(userid);
		
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Failed to issue');");
				out.println("location='bookrequest.jsp';");
			  	out.println("</script>");
			}
		}
	

}
