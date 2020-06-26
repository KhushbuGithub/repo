package com.capgemini.bookmydoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.UserDAO;
import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.exception.UserException;
import com.capgemini.bookmydoctor.validation.Validation;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public boolean addUser(User user) {
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return dao.addUser(user);
//		
//		if(Validation.isId(user.getUserId())) {
//			if(Validation.isName(user.getName())) {
//				if(Validation.isEmail(user.getEmail())) {
//					if(Validation.isPassword(user.getPassword())) {
//						if(Validation.isName(user.getUserType())) {
//							return dao.addUser(user);
//							}else {
//						throw new UserException("The UserType should contain atleast one lowercase or one uppercase letter");
//					}
//				}else {
//					throw new UserException("The password must contain one lowercase characters, one uppercase characters , one special symbols in the list \"@#$%\" and length at least 6 characters");
//				}
//			}else {
//				throw new UserException("Email must contain one lowercase characters, one uppercase characters, Numbers from 0-9 , one special symbols in the list '-_.' and it should contain '@' followed by '.'");
//			}
//		}else {
//			throw new UserException("The name must contain one lowercase characters, one  uppercase characters and minimum length of 4");
//		}
//	}else {
//		throw new UserException("The Id must contain numbers between 0-9 and minimum length of 1");
//	}
}

	
    @Override
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public boolean deleteUser(int userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public boolean changePassword(int userId, String password) {
		//return dao.changePassword(userId, encoder.encode(password));
		if(Validation.isId(userId)) {
			if(Validation.isPassword(password)) {
				return dao.changePassword(userId, encoder.encode(password));
			}else {
				throw new UserException("The password must contain one lowercase characters, one uppercase characters , one special symbols in the list \"@#$%\" and length at least 6 characters");
			}
		}else {
			throw new UserException("The Id must contain numbers between 0-9 and minimum length of 1");
		}
	}

	@Override
	public User login(String email, String password) {
		return dao.login(email, password);
	}

	
	

}
