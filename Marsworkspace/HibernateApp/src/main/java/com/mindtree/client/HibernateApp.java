package com.mindtree.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mindtree.entity.User;

public class HibernateApp {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		User user=new User();
		user.setName("Gokul");
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}

}
