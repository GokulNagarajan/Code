package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.Dao.UserDao;
import com.mindtree.entity.User;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	public void createUser(User u) {
		userDao.addUser(u);
	}

	public List<User> getUsers() {
		return userDao.getAllUsers();
	}

}
