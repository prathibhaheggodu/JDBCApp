package com.qspiders.sdet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MyFirstJDBCApp {
	public static void main(String[] args) {
		String dbUrl = 
				"jdbc:mysql://localhost:3306/sdet_db";
		
		String query = "select * from students_info";
		
		try(Connection con = 
				DriverManager
					.getConnection(dbUrl, "root", "root");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			
			/*
			 * 4. Process the Results
			 */
			while(rs.next()){
				int regno = rs.getInt("regno");
				String fname = rs.getString("firstname");
				String mname = rs.getString("middlename");
				String lname = rs.getString("lastname");
				
				System.out.println("Reg No: "+regno);
				System.out.println("First Name: "+fname);
				System.out.println("Middle Name: "+mname);
				System.out.println("Last Name: "+lname);
				System.out.println("********~**********");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
