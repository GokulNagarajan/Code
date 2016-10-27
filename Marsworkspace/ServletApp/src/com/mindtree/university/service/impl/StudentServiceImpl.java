package com.mindtree.university.service.impl;

import java.util.List;

import com.mindtree.university.dao.StudentDao;
import com.mindtree.university.dao.impl.StudentDaoImpl;
import com.mindtree.university.entity.Department;
import com.mindtree.university.entity.Student;
import com.mindtree.university.exceptions.BusinessException;
import com.mindtree.university.exceptions.DaoException;
import com.mindtree.university.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = new StudentDaoImpl();

	@Override
	public void addStudent(Student student) throws BusinessException {
		try {
			studentDao.createStudent(student);
		} catch (DaoException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Student> getStudentByDepartment(Department department) throws BusinessException {
		try {
			return studentDao.readStudentsByDepartment(department);
		} catch (DaoException e) {
			throw new BusinessException(e);
		}
	}

}
