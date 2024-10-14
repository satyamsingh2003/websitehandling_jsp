package org.studyeasy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	public static Connection getConnection(){
		String dbUrl = "jdbc:mysql://localhost:3306/studyeasy?useSSL=false";
		String dbUsername = "root";
		String dbPassword = "satyamsingh@2003";
		Connection con = null;
		try {
			// 1. Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
//			 2. Establish a connection
			con = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
//			System.out.println("Connection established: "+con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
