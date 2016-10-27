package com.mindtree.university.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.university.dao.DepartmentDao;
import com.mindtree.university.dao.util.DBUtils;
import com.mindtree.university.entity.Department;
import com.mindtree.university.exceptions.DaoException;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> readAllDepartments() throws DaoException {
		String sql = "SELECT id, name FROM department";
		try (Connection connection = DBUtils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {
			List<Department> departments = new ArrayList<>();
			while (resultSet.next()) {
				departments.add(new Department(resultSet.getLong("id"), resultSet.getString("name")));
			}
			return departments;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(e);
		}
	}

}
