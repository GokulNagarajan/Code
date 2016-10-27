package com.mindtree.impl;

import com.mindtree.entity.User;
import com.mindtree.service.RegisterService;
import com.mindtree.utility.DbConnector;

public class RegisterImpl implements RegisterService{

	@Override
	public boolean registercheck(User user) {
		DbConnector db=new DbConnector();
		db.createuser(user);
		if(db.create)
			return true;
		return false;
	}

}
