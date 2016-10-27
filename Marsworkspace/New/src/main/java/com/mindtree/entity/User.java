package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="user")
public class User {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="Congratulation "+this.name;
		return str;
	}
	@Column(name="username")
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
