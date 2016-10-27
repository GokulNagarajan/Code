package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	String name;
	@Id
	String email;
	int age;
	public User() {
	}
	public User(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		String str=getEmail()+"\t"+getName()+"\t"+getAge();
		return str;
	}
}