package com.selenium.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.*;
import com.selenium.database.MySQLDatabaseConnection;

public class GetAllValue_DB extends MySQLDatabaseConnection {

	@BeforeTest
	public void connectdb() {
		getConnection();
	}
	@Test(enabled = false)
	public void one() {
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM test_db");
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String location = result.getString("location");

				System.out.println(id + " " + name + " " + location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test(enabled = false)
	public void two() {
		try {
			String sql = "INSERT INTO test_db (id, name, location) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, "4");
			preparedStatement.setString(2, "Shruthy");
			preparedStatement.setString(3, "Trichy");
			preparedStatement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test(enabled = true)
	public void three() {
		
	}
}