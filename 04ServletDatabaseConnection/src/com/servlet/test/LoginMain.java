package com.servlet.test;

import java.sql.*;

import sun.security.util.Password;

public class LoginMain implements interDao{

	

	@Override
	public boolean search(String username, String pass)  {
		 try {
			 JDBConnection jd = new JDBConnection();
			 Connection conn = jd.setConnection();
			 String userdb = null;
			 String passdb = null;
			
			String query = "SELECT * from userdataek";
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					userdb = rs.getString("username");
					passdb = rs.getString("password");
				}
				conn.close();
				System.out.println(userdb+" "+passdb);
				if(username.equals(userdb)){
					if(pass.equals(passdb)){
						return true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
