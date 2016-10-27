package com.mindtree.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.entity.User;

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
	void close()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void createuser (User user) {
		try{  
			start();
			String sql="INSERT INTO USER(username,email,age,password)"+
			"VALUES ('"+user.username+"','"+user.email+"','"+Integer.parseInt(user.age)+"','"+user.password+"')";
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			create=false;
			e.printStackTrace();
		}
		close();
	}
	public void connectuser(User user) {
		// TODO Auto-generated method stub
		try{  
			start();
			ResultSet rs=stmt.executeQuery("select count(*) from user "+
			"where username like '"+user.username+"' and  password like '"+user.password+"'");
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
