package com.mindtree.entity;

public class User {
	public String username;
	public String password;
	public String email;
	public String age;
	public User(String username, String password, String email, String age) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
	}
	public User(String name, String pass) {
		// TODO Auto-generated constructor stub
		super();
		this.username = name;
		this.password = pass;
	}
}
