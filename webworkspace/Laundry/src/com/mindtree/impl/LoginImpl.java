package com.mindtree.impl;

import com.mindtree.service.LoginService;
import com.mindtree.utility.DbConnector;

public class LoginImpl implements LoginService
{

	@Override
	public boolean logincheck(String user, String pass) {
		// TODO Auto-generated method stub
		DbConnector db=new DbConnector();
		db.connect(user, pass);
		if(db.present)
			return true;
		return false;
	}
	
}
