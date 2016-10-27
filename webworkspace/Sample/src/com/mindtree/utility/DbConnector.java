package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {
	public boolean present = false;
	public boolean create = true ;
	private Statement stmt;
	private Connection con;
	void start()
	{
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Welcome123");  
			stmt=con.createStatement();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void close() throws SQLException
	{
		con.close();
	}
	public void connect (String user,String pass) {
		try{  
			start();
			ResultSet rs=stmt.executeQuery("select count(*) from user where username like '"+user+"' and  password like '"+pass+"'");
			while(rs.next())
			{
				if(rs.getInt(1)>0)
					present = true;
			}
			close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
