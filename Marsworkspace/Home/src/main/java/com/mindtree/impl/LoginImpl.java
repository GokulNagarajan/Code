package com.mindtree.impl;

import java.sql.SQLException;

import com.mindtree.dao.Userdao;
import com.mindtree.daoimpl.Userdaoimpl;
import com.mindtree.entity.User;
import com.mindtree.service.LoginService;
import com.mindtree.utility.DbConnector;

public class LoginImpl implements LoginService
{
	public boolean logincheck(User user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Userdao dao=new Userdaoimpl();
		if(dao.login(user))
			return true;
		return false;
	}	
}
