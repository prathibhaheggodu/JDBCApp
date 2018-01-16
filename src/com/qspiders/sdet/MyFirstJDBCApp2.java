package com.qspiders.sdet;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJDBCApp2 {

	// 5 steps:
	// 1. Load the driver
	// 2. Get the DB CONNECTION VIA driver
	// 3. Issue SQL QUERIES VIA CONNECTION
	// 4. Process the results returned by SQL queries
	// 5.CLose all the JDBC objects

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/sdet_db";
		String query = "Select * from students_info"; // query

		/**
		 * Using try Resource for classes which implements closeable interface closes
		 * all objects created automatically
		 */
		try (Connection con = DriverManager.getConnection(dbUrl, "j2ee", "j2ee");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query))

		{
			while (rs.next()) {
				int registerno = rs.getInt("regno");
				String firstname = rs.getString("firstname");
				String middlename = rs.getString("middlename");
				String lastname = rs.getString("lastname");

				// to print the values in resultset

				System.out.println("Regno: " + registerno);
				System.out.println("FirstName: " + firstname);
				System.out.println("MiddleName: " + middlename);
				System.out.println("LastName: " + lastname);
				System.out.println("..................");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
