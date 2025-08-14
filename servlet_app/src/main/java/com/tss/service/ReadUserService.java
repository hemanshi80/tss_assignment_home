package com.tss.service;

import java.sql.Connection;
import java.util.List;

import com.tss.dao.UserDao;
import com.tss.model.User;

public class ReadUserService {
	 private UserDao userDao;

	    public ReadUserService() {
	        this.userDao = new UserDao();
	    }

	    public List<User> fetchAllUsers(Connection connection) {
	        return userDao.getAllUsers(connection);
	    }
}
