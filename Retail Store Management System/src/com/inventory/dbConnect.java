package com.inventory;
import java.sql.DriverManager;
import java.sql.*;



public class dbConnect {
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/retail store management system db";		
	private static String user = "root";
	private static String pass = "root";
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, pass);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
