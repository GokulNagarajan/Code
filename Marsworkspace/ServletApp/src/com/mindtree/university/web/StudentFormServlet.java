package com.mindtree.university.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.university.entity.Department;
import com.mindtree.university.exceptions.BusinessException;
import com.mindtree.university.service.DepartmentService;
import com.mindtree.university.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class SaveDepartmentServlet
 */
@SuppressWarnings("serial")
public class StudentFormServlet extends HttpServlet {

	private DepartmentService departmentService = new DepartmentServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Department> departments;
		try {
			departments = departmentService.getAllDepartments();
			request.setAttribute("depts", departments);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("addStudentForm.jsp").forward(request, response);
	}
}
