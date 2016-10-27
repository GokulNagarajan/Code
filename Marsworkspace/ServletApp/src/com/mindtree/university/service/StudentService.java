package com.mindtree.university.service;

import java.util.List;

import com.mindtree.university.entity.Department;
import com.mindtree.university.entity.Student;
import com.mindtree.university.exceptions.BusinessException;

public interface StudentService {

	void addStudent(Student student) throws BusinessException;

	List<Student> getStudentByDepartment(Department department) throws BusinessException;
}
