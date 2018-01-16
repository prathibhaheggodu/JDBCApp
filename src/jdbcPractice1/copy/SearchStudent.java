package jdbcPractice1.copy;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchStudent {
	public static void main(String[] args) {
		
		System.out.println("Enter a Regno: ");
		Scanner in = new Scanner(System.in);
		String regno = in.nextLine();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
				
		try {
			
			
			
			/*
			 * 2. Get the Database Connection via Driver
			 */
			String dbUrl = 
			"jdbc:mysql://localhost:3306/sdet_db";
			con = DriverManager.getConnection(dbUrl, "j2ee", "j2ee");
			System.out.println("Got the Db Connection");
			/*
			 * 3. Issue the Sql query
			 */
			String query = "select * from students_info "
					+ " where regno=?";
			pstmt = con.prepareStatement(query);
			int regnum = Integer.parseInt(regno);
			pstmt.setInt(1, regnum);
			rs = pstmt.executeQuery();
			
			/*
			 * 4. Process the Results
			 */
			while(rs.next()){
				regno = rs.getString("regno");
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
