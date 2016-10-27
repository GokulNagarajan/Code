package com.mindtree.entity;

public class User {
	public String username;
	public String email;
	public int age;
	public String password;
	public User(String user, String email, int age, String pass) {
		// TODO Auto-generated constructor stub
		this.username=user;
		this.email=email;
		this.age=age;
		this.password=pass;
	}
}
