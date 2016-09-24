package com.nucleus.ekas.DAO;

import java.sql.*;

import sun.security.util.Password;

public class LoginMain implements interDao{
	
	JDBConnection jd = new JDBConnection();
	Connection conn = null;
	int value = 0;
	@Override
	public boolean search(String username, String pass)  {
		try {
			 conn = jd.setConnection();
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
				
				System.out.println(userdb+" "+passdb);
				if(username.equals(userdb)){
					if(pass.equals(passdb)){
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return false;
	}

	@Override
	public boolean addProd(String itemName, Float itemQty) {
		
		try {
			conn = jd.setConnection();		
			
			String itemName1 = null;
			Float itemQty1 = 0.0f;
			int count = 0;
			
			String querySelect = "Select * from prodInventoryEk";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			while (rs.next()) {
				
				itemName1 = rs.getString("ProdName");
				itemQty1 = rs.getFloat("ProdQty");
				
				if(itemName.equalsIgnoreCase(itemName1)){
					System.out.println(itemName1 + ":" + itemName);
					count++;
					break;
				}					
			}
			if(count == 1){
				String query = "update prodInventoryEk set ProdQty = ProdQty + ? where ProdName = ?";					
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setFloat(1, itemQty);
				pstmt.setString(2, itemName);
				pstmt.executeUpdate();
				return false;
			}
			else{
				String query = "insert into prodInventoryEk(ProdName,ProdQty) values(?,?)";					
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, itemName);
				pstmt.setFloat(2, itemQty);
				pstmt.executeUpdate();
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return false;		
	}

	@Override
	public boolean buyProd(String itemName, Float itemQty) {
		try {
			conn = jd.setConnection();
			
			String itemName1 = null;
			Float itemQty1 = 0.0f;
			int count = 0;
			
			String querySelect = "Select * from prodInventoryEk";
			Statement stmt = null;
		
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(querySelect);
			while (rs.next()) {
				
				itemName1 = rs.getString("ProdName");
				itemQty1 = rs.getFloat("ProdQty");
				
				if(itemName.equalsIgnoreCase(itemName1)){
					System.out.println(itemName1 + ":" + itemName);
					count++;
					break;
				}					
			}
			if(count == 1){
				if(itemQty > itemQty1){
					return false;
				}
				String query = "update prodInventoryEk set ProdQty = ProdQty - ? where ProdName = ?";					
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setFloat(1, itemQty);
				pstmt.setString(2, itemName);
				pstmt.executeUpdate();
				return true;
			}
			else{
				return false;
			}			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;			
	}

	@Override
	public float searchProd(String itemName) {
		try {
			conn = jd.setConnection();
			String itemName1 = null;
			Float itemQty1 = 0.0f;
			int count = 0;
			
		
			String querySelect = "Select * from prodInventoryEk";
			Statement stmt = null;		
			stmt = conn.createStatement();	
		
			ResultSet rs = stmt.executeQuery(querySelect);
			while (rs.next()) {
			
				itemName1 = rs.getString("ProdName");
				itemQty1 = rs.getFloat("ProdQty");
			
				if(itemName.equalsIgnoreCase(itemName1)){
					System.out.println(itemName1 + ":" + itemName);
					return itemQty1;
				}					
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (-1);			
	}

	@Override
	public boolean deleteProd(String itemName) {
		try {
			conn = jd.setConnection();		
			
			String itemName1 = null;
			Float itemQty1 = 0.0f;
			int count = 0;
			
			String querySelect = "Select * from prodInventoryEk";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(querySelect);
			while (rs.next()) {
				
				itemName1 = rs.getString("ProdName");
				itemQty1 = rs.getFloat("ProdQty");
				
				if(itemName.equalsIgnoreCase(itemName1)){
					System.out.println(itemName1 + ":" + itemName);
					count++;
					break;
				}					
			}
			if(count == 1){
				String query = "delete from prodInventoryEk where ProdName = ?";					
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, itemName);
				pstmt.executeUpdate();
				return true;
			}
			else{
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				conn.commit();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return false;		
	}
}
