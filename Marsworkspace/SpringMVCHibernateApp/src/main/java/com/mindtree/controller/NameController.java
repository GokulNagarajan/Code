package com.mindtree.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.mindtree.entity.User;

/**
 * Servlet implementation class NameController
 */
@WebServlet("/NamePost")
public class NameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		System.out.println("Before Name saved "+name);
		ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");
		User user=(User) context.getBean("user");
		HttpSession hs=request.getSession();
		if(hs!=null)
			hs.setAttribute("name", name);
		long start=System.currentTimeMillis();
		//BeanFactory bean=new XmlBeanFactory(new FileSystemResource("NewFile.xml"));
		//User user=(User)bean.getBean("user");
		user.setName(name);
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(user);
		long end=System.currentTimeMillis();
		System.out.println("time taken = "+(end-start));
		System.out.println("After Name saved "+name);
		session.getTransaction().commit();
		session.close();
		sf.close();
		//request.getRequestDispatcher("/welcome.html").forward(request, response);
		response.sendRedirect("springmvc");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
