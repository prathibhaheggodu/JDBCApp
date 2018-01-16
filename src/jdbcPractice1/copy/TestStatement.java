
package jdbcPractice1.copy;

import java.io.FileReader;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class TestStatement {
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
				
		try {
			
			String path = "G:\\db.properties";
			FileReader file = new FileReader(path);
			Properties prop = new Properties();
			prop.load(file);
			
			
			/*
			 * 2. Get the Database Connection via Driver
			 */
			String dbUrl = "jdbc:mysql://localhost:3306/sdet_db";
			con = DriverManager.getConnection(dbUrl,prop);
			
			System.out.println("Got the Db Connection");
			/*
			 * 3. Issue the Sql query
			 */
			String query = "delete from students_info "
					+ " where regno=1";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(query);
			
			
			/*
			 * 4. Process the Results
			 */
			if(count > 0) {
				System.out.println("deleted...");
			}else {
				System.out.println("Data is not present");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) {
					con.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
