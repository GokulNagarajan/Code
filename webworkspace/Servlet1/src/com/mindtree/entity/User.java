package com.mindtree.entity;

public class User {
	public String username;
	public String emailid;
	public String age;
	public String password;
	public User(String username, String emailid, String age, String password) {
		super();
		this.username = username;
		this.emailid = emailid;
		this.age = age;
		this.password = password;
	}
	public User(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
