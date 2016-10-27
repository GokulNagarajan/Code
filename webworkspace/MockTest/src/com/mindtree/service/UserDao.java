package com.mindtree.service;

import Exception.DaoException;

import com.mindtree.entity.User;

public interface UserDao {

	public void getUser(String userName, String password) throws DaoException;

	public void addUser(User user) throws DaoException ;
	
}