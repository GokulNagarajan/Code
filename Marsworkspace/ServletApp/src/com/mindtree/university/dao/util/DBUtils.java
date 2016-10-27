package com.mindtree.university.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/kalingadb";
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Welcome123";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER_CLASS);
		Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		return connection;
	}
}
