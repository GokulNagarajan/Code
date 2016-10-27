package com.mindtree.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	int id;
	String name;
	@ManyToMany(targetEntity=Student.class)
	Set<Student> studentSet;
	public Department(){}
	public Department(int id, String name, Set<Student> studentSet) {
		super();
		this.id = id;
		this.name = name;
		this.studentSet = studentSet;
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
	public Set<Student> getStudentSet() {
		return studentSet;
	}
	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}
	
}
