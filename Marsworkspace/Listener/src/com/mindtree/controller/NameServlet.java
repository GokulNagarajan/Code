package com.mindtree.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        String n=request.getParameter("username");  
	        out.print("Welcome "+n);    
	        HttpSession session=request.getSession();  
	        session.setAttribute("uname",n);    
	        //retrieving data from ServletContext object  
	        ServletContext ctx=getServletContext();  
	        int total=(Integer)ctx.getAttribute("totalusers");  
	        int current=(Integer)ctx.getAttribute("currentusers");  
	        out.print("<br>total users= "+total);  
	        out.print("<br>current users= "+current);   
	        out.print("<br><a href='logout'>logout</a>");  
	        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
