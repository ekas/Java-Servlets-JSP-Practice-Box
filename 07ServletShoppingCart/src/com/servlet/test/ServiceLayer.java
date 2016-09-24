package com.servlet.test;

public class ServiceLayer {
	public int calc(String[] items) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < items.length; i++) {
			if(items[i].equals("jsp")){
				sum+=100;
			}
			if(items[i].equals("jquery")){
				sum+=100;
			}
			if(items[i].equals("ajax")){
				sum+=100;
			}
		}
		
	return sum;
	}
}
