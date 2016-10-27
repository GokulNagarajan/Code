package com.mindtree.Dao;

import com.mindtree.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	Employee e1=new Employee();  
	public void addEmployee() {
		e1.setName("Gokul Nagarajan");  
	    e1.setEmail("gokulngone@gmail.com");  	      
	}

	public Employee getEmployee() {
		addEmployee();
		return e1;
	}

}
