package com.mindtree.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.entity.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addUser(User u) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(u);
		session.getTransaction().commit();
	}

	public List<User> getAllUsers() {
		List<User> list=null;
		Session session=sessionFactory.openSession();
		list=session.createQuery("from HibernateUser").list();
		return list;
	}

}
