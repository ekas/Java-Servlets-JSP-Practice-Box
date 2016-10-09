package com.ekas.ServiceLayer;

import com.ekas.DAO.LoginMain;
import com.ekas.DAO.interDao;


public class ServiceLayer {

	private String user ;
	private String pass ;
	private String itemName;
	private Float itemQty;
	boolean ret = false;
	
	interDao lm = new LoginMain();	
	
	public boolean setVars(String user, String pass) {
		
		// TODO Auto-generated method stub
		this.user = user;
		this.pass = pass;
		
		//System.out.println("Hello " + user + " your password is : " + pass);
		
		ret = lm.search(user,pass);
		System.out.println(ret);
		
		return ret;		
	}
	
	public void setVarsItem(String itemname,Float itemqtyf) {
		
		this.itemName = itemname;
		this.itemQty = itemqtyf;
	}
	public void setVarsItem(String itemname) {
		
		this.itemName = itemname;
	}
	
	
	public boolean setAddItem() {
		ret = lm.addProd(itemName,itemQty);
		return ret;
	}
	
	public boolean setBuyItem() {
		ret = lm.buyProd(itemName,itemQty);
		return ret;
	}
	
	public float setSearchItem() {
		float val = lm.searchProd(itemName);
		return val;
	}
	
	public boolean setDeleteItem() {
		ret = lm.deleteProd(itemName);
		return ret;
	}
}
