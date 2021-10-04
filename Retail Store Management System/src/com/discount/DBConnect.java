/**
 * 
 */
package com.discount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Supun Dileepa
 *
 */
public class DBConnect {
	// Establishing connection
		public static Connection Connect() {
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retail store management system db", "root", "");
				System.out.println("CONNECTED TO DATABASE");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;

		}

}
