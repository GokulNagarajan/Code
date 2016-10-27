package com.mindtree.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	int id;
	String name;
	@ManyToMany(targetEntity=Department.class)
	Set<?> departmentList;
	public Student(){}
	public Student(int id, String name, Set<?> departmentList) {
		super();
		this.id = id;
		this.name = name;
		this.departmentList = departmentList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<?> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(Set<?> departmentList) {
		this.departmentList = departmentList;
	}
	
}
