package com.mindtree.university.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.university.dao.StudentDao;
import com.mindtree.university.dao.util.DBUtils;
import com.mindtree.university.entity.Department;
import com.mindtree.university.entity.Student;
import com.mindtree.university.exceptions.DaoException;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void createStudent(Student student) throws DaoException {
		String sql = "INSERT INTO student" + "(first_name,last_name,dept_id) " + " values (?,?,?)";
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setLong(3, student.getDepartment().getId());
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Student> readStudentsByDepartment(Department department) throws DaoException {
		String sql = "SELECT s.id, s.first_name, s.last_name FROM "
				+ "student s join department d where s.dept_id = d.id and d.id = " + department.getId();
		try (Connection connection = DBUtils.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);) {
			List<Student> students = new ArrayList<>();
			while (resultSet.next()) {
				students.add(new Student(resultSet.getLong("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), null));
			}
			return students;
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(e);
		}
	}

}
