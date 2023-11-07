package dataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbconections {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/qadbt"; // Correct the URL format
        String username = "root";
        String password = "";

        // Establish the connection
        	conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connected to the MySQL database!");
                // You can perform database operations here
              
            }
        
        
        stmt = conn.createStatement();
        String sqlQuery = "SELECT * FROM employeeinfo";
        rs = stmt.executeQuery(sqlQuery);

        while (rs.next()) {
            int id = rs.getInt("id"); // Replace with your column names
            String name = rs.getString("name");
            int age = rs.getInt("age");

            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }
        
        conn.close(); // Close the connection when done
    }
}
