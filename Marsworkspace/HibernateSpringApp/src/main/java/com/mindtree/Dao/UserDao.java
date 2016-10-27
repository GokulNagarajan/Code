package com.mindtree.Dao;

import java.util.List;

import com.mindtree.entity.User;

public interface UserDao {
	public void addUser(User u);
	public List<User> getAllUsers();
}
