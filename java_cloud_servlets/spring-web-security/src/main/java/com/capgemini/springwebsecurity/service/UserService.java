package com.capgemini.springwebsecurity.service;

import com.capgemini.springwebsecurity.bean.UserInfoBean;

public interface UserService {
	
	public boolean register(UserInfoBean userInfoBean);
	public UserInfoBean getUser(String username);

}
