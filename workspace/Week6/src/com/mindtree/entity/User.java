package com.mindtree.entity;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	String id;
	String name;
	int age;
	double sal;
	public User()
	{
		id="";
		name="";
		age=0;
		sal=0;
	}
	@Override
	public String toString() {
		return id+"\t"+name+"\t\t"+age+"\t"+sal;
	}
	public User(String id, String name, int age, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sal = sal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
}
