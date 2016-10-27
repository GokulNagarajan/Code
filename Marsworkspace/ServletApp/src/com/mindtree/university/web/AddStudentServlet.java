package com.mindtree.university.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.university.entity.Department;
import com.mindtree.university.entity.Student;
import com.mindtree.university.exceptions.BusinessException;
import com.mindtree.university.service.StudentService;
import com.mindtree.university.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService studentService = new StudentServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		long deptId = Long.parseLong(request.getParameter("department"));
		System.out.println(">>>>>>>>>>>" + lastName + " >>>>" + deptId);
		try {
			studentService.addStudent(new Student(0l, firstName, lastName, new Department(deptId, null)));
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

}
