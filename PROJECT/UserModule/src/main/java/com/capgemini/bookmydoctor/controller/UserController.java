package com.capgemini.bookmydoctor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.dto.UserResponse;
import com.capgemini.bookmydoctor.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping(path = "/register-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse registerUser(@RequestBody User user) {
		UserResponse response = new UserResponse();
		if (service.addUser(user)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User registered");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User already exists");
		}
		return response;
	}

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse auth(@RequestBody User bean) {
		User userBean = service.login(bean.getEmail(), bean.getPassword());
		UserResponse response = new UserResponse();
		if (userBean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("user found for the credentials");
			response.setUser(Arrays.asList(userBean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("invalid credentials");
		}
		return response;
	}

	@GetMapping(path = "/view-allusers", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse viewAllUsers() {
		UserResponse response = new UserResponse();
		List<User> list = service.getAllUsers();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Users found");
			response.setUser(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Users data not found ");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteuser(@PathVariable("id") int id) {
		UserResponse response = new UserResponse();
		if (service.deleteUser(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("user deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("user not found");
		}
		return response;
	}

//	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public UserResponse changePassword(@RequestBody User user) {
//		UserResponse response = new UserResponse();
//		if (service.changePassword(user.getUserId(), user.getPassword())) {
//			response.setStatusCode(201);
//			response.setMessage("Success");
//			response.setDescription("password changed");
//		} else {
//			response.setStatusCode(401);
//			response.setMessage("Failure");
//			response.setDescription("password not changed");
//		}
//		return response;
//	}
}
