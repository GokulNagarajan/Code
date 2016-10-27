package com.mindtree.university.dao;

import java.util.List;

import com.mindtree.university.entity.Department;
import com.mindtree.university.entity.Student;
import com.mindtree.university.exceptions.DaoException;

public interface StudentDao {

	void createStudent(Student student) throws DaoException;

	List<Student> readStudentsByDepartment(Department department) throws DaoException;
}
