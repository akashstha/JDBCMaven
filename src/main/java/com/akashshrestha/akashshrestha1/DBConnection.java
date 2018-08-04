package com.akashshrestha.akashshrestha1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection conn=null;
	try {
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false", "root", "akash");
		System.out.println("test");
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return conn;

	}

}
