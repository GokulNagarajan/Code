package com.mindtree.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mindtree.entity.User;

public class MVCController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		System.out.println("Before Name saved "+name);
		User user=new User();
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		user.setName(name);
		session.beginTransaction();
		session.save(user);
		System.out.println("After Name saved "+name);
		session.getTransaction().commit();
		session.close();
		sf.close();
		//request.getRequestDispatcher("/welcome.html").forward(request, response);
		//response.sendRedirect("springmvc");
		ModelAndView mav=new ModelAndView("index");
		mav.addObject("user", user);
		System.out.println(user);
		return mav;
	}
	

}
