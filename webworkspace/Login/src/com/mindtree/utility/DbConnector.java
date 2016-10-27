package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnector {
	public boolean present = false;
	public void connect (String user,String pass) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Welcome123");  
			System.out.println("Connecting the database");
			System.out.println();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select count(*) from user where username like '"+user+"' password like '"+pass+"'");
			while(rs.next())
			{
				if(rs.getInt(1)>0)
					present = true;
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
