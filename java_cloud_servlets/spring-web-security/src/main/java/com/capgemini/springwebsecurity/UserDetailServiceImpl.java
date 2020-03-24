package com.capgemini.springwebsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.capgemini.springwebsecurity.dao.UserDAO;

@Component
public class UserDetailServiceImpl  implements UserDetailsService{
	
	@Autowired
	private UserDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetailsImpl= new UserDetailsImpl();
		userDetailsImpl.setUserInfoBean(dao.getUser(username));
		return userDetailsImpl;
	}

}
