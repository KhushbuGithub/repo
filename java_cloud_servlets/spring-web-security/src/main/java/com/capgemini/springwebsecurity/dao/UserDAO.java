package com.capgemini.springwebsecurity.dao;

import com.capgemini.springwebsecurity.bean.UserInfoBean;

public interface UserDAO {
	
	public boolean register(UserInfoBean userInfoBean);
	public UserInfoBean getUser(String username);
	

}
