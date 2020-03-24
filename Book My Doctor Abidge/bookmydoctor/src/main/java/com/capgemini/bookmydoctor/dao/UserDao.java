package com.capgemini.bookmydoctor.dao;

import com.capgemini.bookmydoctor.dto.UserDto;

public interface UserDao {

	public boolean registerUser(UserDto user);
	
	public boolean addUser(UserDto user);
}
