package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/e_comm";
		final String USERNAME = "root";
		final String PASSWORD = "root";
		
		try {
			Class.forName(DRIVERCLASS);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			if(conn == null) {
				System.out.println("Database failed to connect!");
			} else {
				System.out.println("Database connected successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
//	public static void main(String[] args) {
//		DBConnection.getConnection();
//	}
}
