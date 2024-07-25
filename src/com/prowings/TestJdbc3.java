package com.prowings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc3 {
	

	public static void main (String[] args) {
		
		// code to fetch the data from student table -from employee DB
		
		// create the connection to database
		Connection con = null;
		
		try {
			// Step 1: Register the driver class (optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2: Create connection
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "291294");
			// Step 3: Create Statement
			Statement stmt = con.createStatement();
			// Step 4: Execute query
			int res = stmt.executeUpdate("Update Student set name='vishal' where id=50");
			
			if(res>0)
				System.out.println("DB Operation executed Succesfully..affected rows are :"+res);
			
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("unable to load the Driver because driver class not found!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Some exception occured while coonecting to DB!!");
			e.printStackTrace();
		}  
		finally {
			try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error while closing the connection!!");
			e.printStackTrace();
		}
		}
	}
}
