package com.mindtree.entity;


public class User {
	public String name;
	public String password;
	public String email;
	public int age;
	public String phone;
	public String country;
	public java.sql.Date dob;
	public User(String username, String password, String email, int age, String phone, String country, java.sql.Date dob) {
		super();
		this.name = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.country = country;
		this.dob = dob;
	}
	public User(String name, String pass) {
		// TODO Auto-generated constructor stub
		super();
		this.name = name;
		this.password = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public java.sql.Date getDob() {
		return dob;
	}
	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}
	
}
