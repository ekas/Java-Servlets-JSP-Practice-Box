package com.ekas.DAO;

public class product {
	private String itemName = null; 
	private float itemQty = 0;
		
	public product(String itemName, float itemQty) {
		super();
		this.itemName = itemName;
		this.itemQty = itemQty;
	}	
	
	public product() {
		super();
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemQty() {
		return itemQty;
	}
	public void setItemQty(float itemQty) {
		this.itemQty = itemQty;
	}
	
	
}
