 package com.nucleus.ekas.DAO;

import java.sql.SQLException;

public interface interDao {
	public boolean search(String username, String pass) ;
	
	public boolean addProd(String itemName, Float itemQty);
	public boolean buyProd(String itemName, Float itemQty);
	public float searchProd(String itemName);
	public boolean deleteProd(String itemName);
}
