package com.mindtree.university.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ListStudentServlet
 */
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long deptId = Long.parseLong(request.getParameter("dept_id"));
		List<Student> students = new ArrayList<>();
		try {
			students = studentService.getStudentByDepartment(new Department(deptId, null));
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("students", students);
		request.getRequestDispatcher("studentTable.jsp").forward(request, response);
	}

}
