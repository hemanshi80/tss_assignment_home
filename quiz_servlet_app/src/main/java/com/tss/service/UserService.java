package com.tss.service;

import com.tss.dao.UserDao;
import com.tss.model.User;

public class UserService {

	private UserDao userDao = new UserDao();

    public boolean register(User user) {
        try {
            return userDao.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public User login(String username, String password) {
        return userDao.validateUser(username, password);
    }
	
}
