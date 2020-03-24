package com.capgemini.springrestsecurity.service;

import java.util.List;

import com.capgemini.springrestsecurity.beans.UserInfoBean;

public interface UserService {
	
	public boolean register(UserInfoBean userInfoBean);
	public UserInfoBean getUser(String username);
	public List<UserInfoBean> getAllUsers();

}
