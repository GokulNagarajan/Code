package com.mindtree.university.dao;

import java.util.List;

import com.mindtree.university.entity.Department;
import com.mindtree.university.exceptions.DaoException;

public interface DepartmentDao {
	
	List<Department> readAllDepartments() throws DaoException;
}
