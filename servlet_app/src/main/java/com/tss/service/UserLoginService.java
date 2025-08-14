package com.tss.service;

import com.tss.dao.UserLoginDao;
import com.tss.model.UserLogin;

public class UserLoginService {
	 private UserLoginDao userDao = new UserLoginDao();

	    public boolean isValidUser(String username, String password, String role) {
	        UserLogin user = new UserLogin(username, password, role);
	        return userDao.validateUser(user);
	    }
}
