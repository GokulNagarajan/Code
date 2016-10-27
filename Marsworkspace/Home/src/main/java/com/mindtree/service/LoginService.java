package com.mindtree.service;

import java.sql.SQLException;

import com.mindtree.entity.User;

public interface LoginService {
	public boolean logincheck(User user) throws ClassNotFoundException, SQLException;
	
}
