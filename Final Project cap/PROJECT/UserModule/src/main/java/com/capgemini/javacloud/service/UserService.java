package com.capgemini.javacloud.service;

import java.util.List;

import com.capgemini.javacloud.dto.User;

public interface UserService {
	
	public boolean addUser(User user);

	public User login(String email,String password);

	public List<User> getAllUsers();

	public boolean deleteUser(int userId);

	public boolean changePassword(int userId ,String password);

}
