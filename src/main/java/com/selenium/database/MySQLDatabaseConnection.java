package com.selenium.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDatabaseConnection {
	
	public Connection con = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Imax123#");
			System.out.println("Database Connected...!!!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
}