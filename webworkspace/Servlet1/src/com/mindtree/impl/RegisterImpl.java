package com.mindtree.impl;

import com.mindtree.service.RegisterService;
import com.mindtree.utility.DbConnector;

public class RegisterImpl implements RegisterService{

	@Override
	public boolean registercheck(String user, String email, String age, String pass) {
		// TODO Auto-generated method stub
		DbConnector db=new DbConnector();
		db.check(user,email,age,pass);
		if(db.create)
			return true;
		return false;
	}

}
