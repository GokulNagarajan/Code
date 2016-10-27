package com.mindtree.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dbutils {
	final static String PATH="com.mysql.jdbc.Driver";
	final static String URL="jdbc:mysql://localhost:3306/cachedrowset";
	final static String USER="root";
	final static String PASS="Welcome123";
	private static Connection con = null;
	public static Connection getCon() throws ClassNotFoundException, SQLException
	{
		Class.forName(PATH);
		con=(Connection) DriverManager.getConnection(URL, USER, PASS);
		return con;
	}
}
