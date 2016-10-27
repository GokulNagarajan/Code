package com.mindtree.impl;

import java.sql.SQLException;

import com.mindtree.dao.Userdao;
import com.mindtree.daoimpl.Userdaoimpl;
import com.mindtree.entity.User;
import com.mindtree.service.RegisterService;
import com.mindtree.utility.DbConnector;

public class RegisterImpl implements RegisterService{
	
	public boolean registercheck(User user) throws ClassNotFoundException, SQLException {
		Userdao dao=new Userdaoimpl();
		if(dao.register(user))
			return true;
		return false;
	}

}
