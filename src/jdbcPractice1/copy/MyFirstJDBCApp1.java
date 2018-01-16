package jdbcPractice1.copy;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstJDBCApp1 {

	// five steps:
	// 1. Load the driver
	// 2. Get the DB CONNECTION VIA driver
	// 3. Issue SQL QUERIES VIA CONNECTION
	// 4. Process the results returned by SQL queries
	// 5. CLose all the JDBC objects

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. Load the driver

			Driver driver = new com.mysql.jdbc.Driver(); // CREATING OBJECT
			DriverManager.registerDriver(driver); // TO LoAD THE DRIVER IN JDBC AND MANAGES DRIVER
			System.out.println("Driver is Loading");

			// piece of software act As mediator between JDBC AND DB

			// Driver constructor throwing exception, handled through try catch block
			// select from java.sql
			// use control space to import

			// 2. Get the DataBase COnnection via Driver

			String dbUrl = "jdbc:mysql://localhost:3306/sdet_db";
			con = DriverManager.getConnection(dbUrl, "j2ee", "j2ee"); // to get the conncetion

			// 3. Issue the sql query

			String query = "Select * from students_info"; // query
			stmt = con.createStatement(); // since statement is used
			rs = stmt.executeQuery(query); // since query is static

			// 4.Process the results returned by sql query

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

		// INSTANCE OF DRIVER
		// JAR IS COLLECTION OF PACKAGES
		// Driver is interface,so cannot be instantiated, CONSTRUCTOR CAN THROW
		// EXCEPTION

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// .......................
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// ...................

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

}
