package com.mindtree.dao;

import java.sql.SQLException;

import com.mindtree.entity.User;

public interface Userdao {
	public boolean login(User user)throws ClassNotFoundException, SQLException;
	public boolean register(User user) throws ClassNotFoundException, SQLException;
}
