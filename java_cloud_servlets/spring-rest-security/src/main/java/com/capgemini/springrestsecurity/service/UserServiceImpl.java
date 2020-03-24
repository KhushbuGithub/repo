package com.capgemini.springrestsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.springrestsecurity.beans.UserInfoBean;
import com.capgemini.springrestsecurity.dao.UserDAO;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao ;
	
	@Autowired
	private BCryptPasswordEncoder passwordencoder;
    

	public boolean register(UserInfoBean userInfoBean) {
		userInfoBean.setPassword(passwordencoder.encode(userInfoBean.getPassword()));
		return dao.register(userInfoBean);
	}

	public UserInfoBean getUser(String username) {
		return dao.getUser(username);
	}
     
	public List<UserInfoBean> getAllUsers() {
		return dao.getAllUsers();
	}

}
