package com.nucleus.ekas.DAO;

import java.sql.*;
public class JDBConnection {
	public Connection conn = null;
	
	public Connection setConnection() throws ClassNotFoundException {
		
		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to Database...");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@finn:1521:orcl","hr","hr");
			System.out.println("Connected to Database Successfully...");
			System.out.println("Data Connection establisheds");
			
			
			//pstmt.setInt(1,1);
			//pstmt.setString(1, "arjun");
			//pstmt.executeQuery();*/
			
			
			//pstmt.executeQuery();
			//System.out.println("Data Entered into the Database");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Data Entery Start");
		}
		return conn;
	}
}
