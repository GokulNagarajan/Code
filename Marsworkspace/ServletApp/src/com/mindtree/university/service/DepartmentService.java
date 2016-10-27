package com.mindtree.university.service;

import java.util.List;

import com.mindtree.university.entity.Department;
import com.mindtree.university.exceptions.BusinessException;

public interface DepartmentService {

	List<Department> getAllDepartments() throws BusinessException;
}
