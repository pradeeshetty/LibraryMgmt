package com.DbConnection;
import java.sql.*;

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
	/* if (i!=0) 
	 return "SUCCESS"; 
	 }*/
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	// return "Oops.. Something went wrong there..!";  
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createConnection();

	}

}
