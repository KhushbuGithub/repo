package com.capgemini.bookmydoctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.capgemini.bookmydoctor.dao.UserDAO;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("auth");
		System.out.println(username);
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setUserInfoBean(dao.getUser(username));
		return userDetailsImpl;
	}

}
