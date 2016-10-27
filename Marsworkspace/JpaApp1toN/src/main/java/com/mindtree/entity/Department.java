package com.mindtree.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Dept")
public class Department {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	int id;
	String name;
	@OneToMany(targetEntity=Student.class,fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	List<Student> studentList;
	public Department(){}
	public Department(int id, String name, List<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.studentList = studentList;
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
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
}
