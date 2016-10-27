package com.mindtree.service;

import com.mindtree.entity.User;

public interface LoginService {
	public boolean logincheck(String user,String pass);
	public boolean logincheck(User user);
}
