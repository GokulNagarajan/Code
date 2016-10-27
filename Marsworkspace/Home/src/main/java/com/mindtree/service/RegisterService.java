package com.mindtree.service;

import java.sql.SQLException;

import com.mindtree.entity.User;

public interface RegisterService {
	public boolean registercheck(User user) throws ClassNotFoundException, SQLException;
}
