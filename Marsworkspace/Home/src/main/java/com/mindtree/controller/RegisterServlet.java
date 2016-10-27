package com.mindtree.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.entity.User;
import com.mindtree.impl.RegisterImpl;
import com.mindtree.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String name=request.getParameter("Name");
		String pass=request.getParameter("Password");
		String age=request.getParameter("Age");
		String email=request.getParameter("Email");
		String country=request.getParameter("Country");
		String phone=request.getParameter("Phone");
		String dob=request.getParameter("DOB");
		int intAge=Integer.parseInt(age);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		java.sql.Date dateDob=null;
		try {
			dateDob = new java.sql.Date(df.parse(dob).getTime());
			System.out.println(dateDob);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		User user=new User(name,pass,email,intAge,phone,country,dateDob);
		RegisterService impl=new RegisterImpl();
		try {
			if(impl.registercheck(user))	
				request.getRequestDispatcher("home.jsp").forward(request, response);
			else
				request.getRequestDispatcher("regfail.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}