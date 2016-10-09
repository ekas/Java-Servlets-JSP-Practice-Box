package com.jsp.test;

public class Employee {
	private float salary = 0;
	private String name = null;
	
	public Employee() {
		super();
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float CalculateHra(){
		float hra = (float) (salary * 0.20);
		return hra;		
	}
}
