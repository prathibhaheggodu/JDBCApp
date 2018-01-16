package com.qspiders.sdet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatePassword {
	public static void main(String[] args) {
		
		System.out.println("Enter the Regno to Update "
				+ "Password: ");
		Scanner in = new Scanner(System.in);
		String regno = in.nextLine();
		System.out.println("Enter Your Old Password: ");
		String oldPasswd = in.nextLine();
		
		System.out.println("Enter Your New Password: ");
		String newPasswd = in.nextLine();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
				
		try {
			
			
			
			/*
			 * 2. Get the Database Connection via Driver
			 */
			String dbUrl = 
			"jdbc:mysql://localhost:3306/sdet_db";
			con = DriverManager.getConnection(dbUrl, "root", "root");
			/*
			 * 3. Issue the Sql query
			 */
			String query = "UPDATE students_info SET password=?"
					+ "  WHERE regno=? AND password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPasswd);
			pstmt.setInt(2, Integer.parseInt(regno));
			pstmt.setString(3, oldPasswd);
			
			int count = pstmt.executeUpdate();
			
			/*
			 * 4. Process the Results
			 */
			if(count > 0) {
				System.out.println("Profile Password Updated");
			}else {
				System.out.println("Please provide a valid regno "
						+ " And Password"); 
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
				if(rs != null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
