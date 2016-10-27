/*
 * Hibernate App
 * User table in database hibernate
 * To use depency injection by hiberate
 */
package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//user table mapping with user class
@Entity(name = "user")
public class User {
	//user table column userid mapping with user class attribute id
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	int id;
	//user table column username mapping with user class attribute name
	@Column(name = "username")
	String name;
	//user table retrieve id
	public int getId() {
		return id;
	}
	//user table insert id
	public void setId(int id) {
		this.id = id;
	}
	//user table retrieve name
	public String getName() {
		return name;
	}
	//user table insert name
	public void setName(String name) {
		this.name = name;
	}
	
}
