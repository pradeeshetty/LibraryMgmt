package com.DbConnection;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

import com.model.AddBook;
import com.model.AddRequest;
import com.model.Register;  
public class DbConnection {
	Connection con = null;
	PreparedStatement preparedStatement = null;
	public static Connection createConnection()
	{
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/library"; //MySQL URL followed by the database name
	String username = "root"; //MySQL username
	String password = "root"; //MySQL password
	try 
	{
	try 
	{
	Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
	} 
	catch (ClassNotFoundException e)
	{
	e.printStackTrace();
	}
	con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	System.out.println("Printing connection object "+con);
	} 
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	return con; 
	}
	
	public void registerUser(Register registerBean)
	{
		try
		{
			con = DbConnection.createConnection();
			String query = "insert into user(name,email,contact,password) values (?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, registerBean.getName());
			preparedStatement.setString(2, registerBean.getEmail());
			preparedStatement.setString(3, registerBean.getContact());
			preparedStatement.setString(4, registerBean.getPassword());
			preparedStatement.executeUpdate();
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 
	 }
	public boolean login(String email,String password)
	{
		boolean isValid = false;
		try
		{
	 con = DbConnection.createConnection();
	 String query = "select email,password from user where email=? and password=?"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, email);
	 preparedStatement.setString(2, password);
	 ResultSet rs = preparedStatement.executeQuery();
     if(rs.next()) {
       System.out.println("User login is valid in DB");
       isValid = true; 
     }
	 
		}
	catch (Exception e) {
		// TODO: handle exception
	}
		return isValid;
	}
	
	public boolean emailexist(String email)
	{
		boolean isValid = false;
		try
		{
			con = DbConnection.createConnection();
			String query = "select email,password from user where email=?"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				System.out.println("Email Exist");
				isValid = true; 
			}
	 
		}
		catch (Exception e) {
		// TODO: handle exception
		}
		return isValid;
	}
	
	
	public int addbook(AddBook ad)
	{
		int i=0;
		try
		{
	 con = DbConnection.createConnection();
	 String query = "insert into books(bookname,author,publisher,price,pages,year,copies,available) values (?,?,?,?,?,?,?,?)"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, ad.getBookname());
	 preparedStatement.setString(2, ad.getAuthor());
	 preparedStatement.setString(3, ad.getPublisher());
	 preparedStatement.setString(4, ad.getPrice());
	 preparedStatement.setString(5, ad.getPages());
	 preparedStatement.setString(6, ad.getYear());
	 preparedStatement.setString(7, ad.getCopies());
	 preparedStatement.setString(8, ad.getAvailability());
	 
	 i= preparedStatement.executeUpdate();
	 System.out.println("i "+i);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	
	public List viewbook()
	{
		List l=new ArrayList();
	
		try
		{
	 con = DbConnection.createConnection();
	 String query = "select * from books"; 
	 Statement s = con.createStatement();

	  s.executeQuery(query);
	 ResultSet rs=s.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getInt("bookid"));
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("author"));
		 l.add(rs.getString("publisher"));
		 l.add(rs.getString("price"));
		 l.add(rs.getString("pages"));
		 l.add(rs.getString("year"));
		 l.add(rs.getString("copies"));
		 l.add(rs.getString("available"));
		 
	 }
	 
	//System.out.println(l);
	
	
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	
	 }
	public List booktoupdate(String bookid)
	{
		List l=new ArrayList();
	
		try
		{
	 con = DbConnection.createConnection();
	 String query = "select * from books where bookid="+bookid+""; 
	 Statement s = con.createStatement();

	  s.executeQuery(query);
	 ResultSet rs=s.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getInt("bookid"));
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("author"));
		 l.add(rs.getString("publisher"));
		 l.add(rs.getString("price"));
		 l.add(rs.getString("pages"));
		 l.add(rs.getString("year"));
		 l.add(rs.getString("copies"));
		 l.add(rs.getString("available"));
		 
	 }
	 
	//System.out.println(l);
	
	
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	
	 }
	
	public int updatebook(AddBook ad,String bookid)
	{
		int i=0;
		System.out.println("book id "+bookid);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "update books set bookname=?,author=?,publisher=?,price=?,pages=?,year=?,copies=?,available=? where bookid="+bookid+""; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, ad.getBookname());
	 preparedStatement.setString(2, ad.getAuthor());
	 preparedStatement.setString(3, ad.getPublisher());
	 preparedStatement.setString(4, ad.getPrice());
	 preparedStatement.setString(5, ad.getPages());
	 preparedStatement.setString(6, ad.getYear());
	 preparedStatement.setString(7, ad.getCopies());
	 preparedStatement.setString(8, ad.getAvailability());
	 
	 i= preparedStatement.executeUpdate();
	 System.out.println("i "+i);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	
	public String getid(String email)
	{
		String id = null;
		//System.out.println("email  "+email);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "select id from user where email=?";
	 //select id from user where email="mepradeep456@gmail.com"
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, email);
	 preparedStatement.execute();
	 ResultSet rs=preparedStatement.getResultSet();
	 while(rs.next())
	 {
		 id=rs.getString("id");
		// System.out.println("id "+id);
	}
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return id;
	
	 }
	
	public int addrequest(AddRequest ar)
	{
		int i=0;
		try
		{
	 con = DbConnection.createConnection();
	 String query = "insert into bookrequest(bookid,userid) values (?,?)"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, ar.getBookid() );
	 preparedStatement.setString(2, ar.getUserid());

	 
	 i= preparedStatement.executeUpdate();
	 System.out.println("i "+i);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	
	public List getrequest()
	{
		String id = null;
		List l=new ArrayList();
		//System.out.println("email  "+email);
		try
		{
	 con = DbConnection.createConnection();
	// String query = "select u.name,b.bookname from books b,user u,bookrequest s where s.bookid=b.bookid and s.userid=u.id";
	 String query = "select s.requestid,u.email,u.name,b.bookname,b.available,b.bookid from books b,user u,bookrequest s where s.bookid=b.bookid and s.userid=u.id";
	 //select id from user where email="mepradeep456@gmail.com"
	 preparedStatement = con.prepareStatement(query); 
			
	 preparedStatement.execute();
	 ResultSet rs=preparedStatement.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getString("email"));
		 l.add(rs.getString("name"));
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("available"));
		 l.add(rs.getString("bookid"));
		 l.add(rs.getString("requestid"));
		 l.add(rs.getString("bookid"));
		 l.add(rs.getString("requestid"));
		 //l.add(rs.getString("name"));
		
	}
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	 }
	
	public int updatavailable(String bookid)
	{
		int available=0;
		System.out.println("book id "+bookid);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "update books set available=available-1 where bookid=? and available > 0"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, bookid);

	 
	 available=preparedStatement.executeUpdate();
	// System.out.println("i "+i);
	 //available=d.getavailable(bookid);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return available;
	
	 }
	public int getavailable(String bookid)
	{
		String available="";
		int book=0;
		System.out.println("book id "+bookid);
		try
		{
			con = DbConnection.createConnection();
			String query = "select available from books where bookid=?";
			//select id from user where email="mepradeep456@gmail.com"
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, bookid);
			
			preparedStatement.execute();
			ResultSet rs=preparedStatement.getResultSet();
			while(rs.next())
			{
	
				available=rs.getString("available");
		
			}
			book=Integer.parseInt(available);
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return book;
	
	 }
	
	
	public int rejectrequest(String bookid,String reqid)
	{
		int i=0;
		
		System.out.println("book id "+bookid);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "delete from bookrequest where bookid=? and requestid=?"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, bookid);
	 preparedStatement.setString(2, reqid);

	 
	i= preparedStatement.executeUpdate();
	// System.out.println("i "+i);
	// i=d.getavailable(bookid);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	
	public int addmsg(AddRequest ar)
	{
		int i=0;
		try
		{
	 con = DbConnection.createConnection();
	 String query = "insert into usermsg(book,user) values (?,?)"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, ar.getBookid() );
	 preparedStatement.setString(2, ar.getUserid());

	 
	 i= preparedStatement.executeUpdate();
	 System.out.println("i "+i);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	
	public List getmsg(String userid)
	{
		String id = null;
		List l=new ArrayList();
		//System.out.println("email  "+email);
		try
		{
	 con = DbConnection.createConnection();
	// String query = "select b.bookname from books b,user u,usermsg s where s.book=b.bookid and s.user=u.id";
	 String query = "select distinct b.bookname from books b,user u,usermsg s where s.book=b.bookid and s.user=?";
	 //select id from user where email="mepradeep456@gmail.com"
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, userid );		
	 preparedStatement.execute();
	 ResultSet rs=preparedStatement.getResultSet();
	 while(rs.next())
	 {

		 l.add(rs.getString("bookname"));
				/*
				 * l.add(rs.getString("available")); l.add(rs.getString("bookid"));
				 * l.add(rs.getString("bookid"));
				 */
		 		//l.add(rs.getString("name"));
		
	}
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	 }
	public int addissuedbooks(AddRequest ar)
	{
		int i=0;
		try
		{
	 con = DbConnection.createConnection();
	 String query = "insert into issuedbooks(ibookid,iuserid) values (?,?)"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, ar.getBookid() );
	 preparedStatement.setString(2, ar.getUserid());

	 
	 i= preparedStatement.executeUpdate();
	 System.out.println("i "+i);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public List getissuedbooks()
	{
		String id = null;
		List l=new ArrayList();
		//System.out.println("email  "+email);
		try
		{
	 con = DbConnection.createConnection();
	// String query = "select u.name,b.bookname from books b,user u,bookrequest s where s.bookid=b.bookid and s.userid=u.id";
	 String query = "select s.id,u.email,u.name,b.bookname,b.bookid from books b,user u,issuedbooks s where s.ibookid=b.bookid and s.iuserid=u.id";
	 //select id from user where email="mepradeep456@gmail.com"
	 preparedStatement = con.prepareStatement(query); 
			
	 preparedStatement.execute();
	 ResultSet rs=preparedStatement.getResultSet();
	 while(rs.next())
	 {
		 l.add(rs.getString("email"));
		 l.add(rs.getString("email"));
		 l.add(rs.getString("name"));
		 l.add(rs.getString("bookname"));
		 l.add(rs.getString("bookid"));
		 l.add(rs.getString("id"));
				/*
				 * l.add(rs.getString("available")); l.add(rs.getString("bookid"));
				 * l.add(rs.getString("bookid"));
				 */
		 //l.add(rs.getString("name"));
		
	}
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return l;
	
	 }
	
	public int increaseavailable(String bookid)
	{
		int available=0;
		DbConnection d=new DbConnection();
		System.out.println("book id "+bookid);
		try
		{
			con = DbConnection.createConnection();
			String query = "update books set available=available+1 where bookid=?"; 
			preparedStatement = con.prepareStatement(query); 
			preparedStatement.setString(1, bookid);
			preparedStatement.executeUpdate();
	// System.out.println("i "+i);
	// available=d.getavailable(bookid);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return available;
	
	 }
	public int deleteissued(String bookid,String issueid)
	{
		int i=0;
		//DbConnection d=new DbConnection();
		System.out.println("book id "+bookid);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "delete from issuedbooks where ibookid=? and id=?"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, bookid);
	 preparedStatement.setString(2, issueid);
	 i= preparedStatement.executeUpdate();
	// System.out.println("i "+i);

	}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	
	public int deletebook(String bookid)
	{
		int i=0;
		
		System.out.println("book id "+bookid);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "delete from books where bookid=?"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, bookid);
	

	 
	i= preparedStatement.executeUpdate();
	// System.out.println("i "+i);
	// i=d.getavailable(bookid);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int DuplicateBooks(AddBook ad)
	{
		int i=0;
		String bookid="";
		DbConnection d=new DbConnection();
		/*
		 * String bookname = "Java",author="James",publisher="Centelon",pages="245";
		 * String year="2014",price="121";
		 */
		//System.out.println("book id "+bookid);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "select * from books"; 
	 preparedStatement = con.prepareStatement(query); 
	 
	

	 
	preparedStatement.execute();
	ResultSet rs=preparedStatement.getResultSet();
	if(rs.next())
	if(ad.getBookname().equals(rs.getString("bookname")) && ad.getAuthor().equals(rs.getString("author")) && ad.getPublisher().equals(rs.getString("publisher")) && ad.getPages().equals(rs.getString("pages")) && ad.getYear().equals(rs.getString("year")) && ad.getPrice().equals(rs.getString("price")))
	{
		
		System.out.println("records exist");
		//increment availability and copies
		bookid=rs.getString("bookid");
		System.out.println("book id is "+bookid);
		i=d.increaseavailablecopies(bookid);
		i=2;
		System.out.println("i is "+i);
		
		
	}
	else
	{
		
		i=d.addbook(ad);
		System.out.println("records unique i is"+i);
	}
		}
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return i;
	
	 }
	public int increaseavailablecopies(String bookid)
	{
		int available=0;
	//	DbConnection d=new DbConnection();
		System.out.println("book id "+bookid);
		try
		{
	 con = DbConnection.createConnection();
	 String query = "update books set available=available+1, copies=copies+1  where bookid=?"; 
	 preparedStatement = con.prepareStatement(query); 
	 preparedStatement.setString(1, bookid);

	 
	 preparedStatement.executeUpdate();
	// System.out.println("i "+i);
	// available=d.getavailable(bookid);
		}

	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return available;
	
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createConnection();
		DbConnection d=new DbConnection();
		//d.viewbook();
		//String id=d.getid("mepradeep456@gmail.com");
		/*
		 * List h=d.getrequest();
		 *  System.out.println(h);
		 */
		//List s=d.getmsg("1");
		//System.out.println(s);
		AddBook ad=new AddBook();
		ad.setBookname("Java");
		ad.setAuthor("James");
		ad.setPages("245");
		ad.setPrice("121");
		ad.setPublisher("Centelon");
		ad.setYear("2014");
		d.DuplicateBooks(ad);
		

	}

}
