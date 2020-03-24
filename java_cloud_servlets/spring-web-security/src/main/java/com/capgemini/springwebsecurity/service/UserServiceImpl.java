package com.capgemini.springwebsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.springwebsecurity.bean.UserInfoBean;
import com.capgemini.springwebsecurity.dao.UserDAO;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao ;
	
	@Autowired
	private BCryptPasswordEncoder passwordencoder;

	@Override
	public boolean register(UserInfoBean userInfoBean) {
		userInfoBean.setPassword(passwordencoder.encode(userInfoBean.getPassword()));
		return dao.register(userInfoBean);
	}

	@Override
	public UserInfoBean getUser(String username) {
		return dao.getUser(username);
	}

}
