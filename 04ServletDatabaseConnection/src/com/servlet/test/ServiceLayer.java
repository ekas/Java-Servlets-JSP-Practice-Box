package com.servlet.test;

import java.io.PrintWriter;

import javax.servlet.ServletContext;

public class ServiceLayer {

	private String user ;
	private String pass ;
	
	
	
	public boolean setVars(String user, String pass) {
		interDao lm = new LoginMain();
		// TODO Auto-generated method stub
		this.user = user;
		this.pass = pass;
		
		//System.out.println("Hello " + user + " your password is : " + pass);
		
		boolean ret = lm.search(user,pass);
		System.out.println(ret);
		
		return ret;		
	}	
}
