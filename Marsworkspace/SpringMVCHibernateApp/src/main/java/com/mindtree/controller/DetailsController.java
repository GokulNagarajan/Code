package com.mindtree.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mindtree.entity.User;

@WebServlet("/springmvc")
public class DetailsController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView m=new ModelAndView("index");
		ApplicationContext context = new ClassPathXmlApplicationContext("NewFile.xml");
		User user=(User) context.getBean("user");
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		user=session.get(User.class,1);
		String userstr=user.toString();
		m.addObject("user", userstr);
		System.out.println(user.toString());
		session.close();
		sf.close();
		return m;
	}

}
