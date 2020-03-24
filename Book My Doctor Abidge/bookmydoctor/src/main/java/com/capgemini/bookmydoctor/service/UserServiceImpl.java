package com.capgemini.bookmydoctor.service;

import com.capgemini.bookmydoctor.dao.UserDaoImpl;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.factory.UserFactory;

public class UserServiceImpl implements UserService {

	UserDaoImpl userDao = (UserDaoImpl) UserFactory.getUserDao();

	public boolean registerUser(UserDto user) {

		return userDao.registerUser(user);
	}

	public boolean addUser(UserDto user) {
		
		return userDao.addUser(user);
	}
}
