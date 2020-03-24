package com.capgemini.springrestsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrestsecurity.beans.UserInfoBean;
import com.capgemini.springrestsecurity.beans.UserResponse;
import com.capgemini.springrestsecurity.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse registerUser(@RequestBody UserInfoBean userInfoBean) {
		UserResponse response = new UserResponse();

		if (service.register(userInfoBean)) {
			response.setStatusCode(201);
			response.setMessage("Sucesss");
			response.setDescription("User Registration Successfull");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Registration Failed");
		}
		return response;
	}

	@GetMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getUser(String username) {
		UserInfoBean userInfoBean = service.getUser(username);
		UserResponse response = new UserResponse();

		if (userInfoBean != null) {
			response.setStatusCode(201);
			response.setMessage("Sucesss");
			response.setDescription("User Record Found");
			response.setUserInfoBean(userInfoBean);

		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Record Not Found");
		}
		return response;
	}

	@GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllUsers() {
		List<UserInfoBean> usersList = service.getAllUsers();
		UserResponse response = new UserResponse();

		if (usersList != null && !usersList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Sucesss");
			response.setDescription("User Record Present");
     		response.setUsersList(usersList);

		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Not Present");
			
		}
		return response;
	}

}
