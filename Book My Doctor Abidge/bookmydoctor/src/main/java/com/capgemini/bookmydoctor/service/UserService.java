package com.capgemini.bookmydoctor.service;

import com.capgemini.bookmydoctor.dto.UserDto;

public interface UserService {

	public boolean registerUser(UserDto user);
	
	public boolean addUser(UserDto user);
}
