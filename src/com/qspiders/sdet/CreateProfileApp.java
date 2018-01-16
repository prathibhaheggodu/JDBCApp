package com.qspiders.sdet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateProfileApp {
	public static void main(String[] args) {
		
		System.out.println("Enter a Regno: ");
		Scanner in = new Scanner(System.in);
		String regno = in.nextLine();
		System.out.println("Enter the First Name: ");
		String fName = in.nextLine();
		System.out.println("Enter the Middle Name: ");
		String mName = in.nextLine();
		System.out.println("Enter the Last Name: ");
		String lName = in.nextLine();
		
		Connection con = null;
		PreparedStatement pstmt = null;
				
		try {
			
			/*
			 * 2. Get the Database Connection via Driver
			 */
			String dbUrl = 
			"jdbc:mysql://localhost:3306/sdet_db";
			con = DriverManager.getConnection(dbUrl, "root", "root");
			System.out.println("Got the Db Connection");
			/*
			 * 3. Issue the Sql query
			 */
			String query = "INSERT INTO students_info "
					+ " values(?,?,?,?)";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(regno));
			pstmt.setString(2, fName);
			pstmt.setString(3, mName);
			pstmt.setString(4, lName);
			int count = pstmt.executeUpdate();
			/*
			 * 4. Process the Results
			 */
			if(count > 0) {
				System.out.println("Success...");
			}else {
				System.out.println("Unsuccessful");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
