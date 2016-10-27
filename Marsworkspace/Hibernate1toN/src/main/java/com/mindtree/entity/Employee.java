package com.mindtree.entity;

public class Employee {
	private int employeeId;  
	private String name,email;  
	private Address address;
	public Employee()
	{
		
	}
	public Employee(int employeeId, String name, String email, Address address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}  
	
}
