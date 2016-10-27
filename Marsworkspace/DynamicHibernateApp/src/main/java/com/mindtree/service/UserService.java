package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.User;

public interface UserService {
	public void createUser(User u);
	public List<User> getUsers();
}
