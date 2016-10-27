package com.mindtree.impl;

import com.mindtree.entity.User;
import com.mindtree.service.LoginService;
import com.mindtree.utility.DbConnector;

public class LoginImpl implements LoginService
{
	@Override
	public boolean logincheck(User user) {
		// TODO Auto-generated method stub
		DbConnector db=new DbConnector();
		db.connectuser(user);
		if(db.present)
			return true;
		return false;
	}	
}
