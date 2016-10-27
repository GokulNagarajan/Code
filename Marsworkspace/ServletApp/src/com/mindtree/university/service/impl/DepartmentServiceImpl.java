package com.mindtree.university.service.impl;

import java.util.List;

import com.mindtree.university.dao.DepartmentDao;
import com.mindtree.university.dao.impl.DepartmentDaoImpl;
import com.mindtree.university.entity.Department;
import com.mindtree.university.exceptions.BusinessException;
import com.mindtree.university.exceptions.DaoException;
import com.mindtree.university.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao = new DepartmentDaoImpl();

	@Override
	public List<Department> getAllDepartments() throws BusinessException {
		try {
			return departmentDao.readAllDepartments();
		} catch (DaoException e) {
			throw new BusinessException();
		}
	}

}
