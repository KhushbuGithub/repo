package com.capgemini.bookmydoctor.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.dto.UserResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class UserController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/template/register-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse registerUser(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);

		return restTemplate.exchange("http://localhost:8085/register-user", HttpMethod.POST, entity, UserResponse.class)
				.getBody();

	}

	@PostMapping(path = "/template/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse auth(@RequestBody User bean) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(bean, headers);

		return restTemplate.exchange("http://localhost:8085/login", HttpMethod.POST, entity, UserResponse.class)
				.getBody();

	}

	@GetMapping(path = "/template/view-allusers", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse viewAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserResponse> entity = new HttpEntity<UserResponse>(headers);
		return restTemplate.exchange("http://localhost:8085/view-allusers", HttpMethod.GET, entity, UserResponse.class)
				.getBody();

	}

	@DeleteMapping(path = "/template/delete-user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteuser(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserResponse> entity = new HttpEntity<UserResponse>(headers);
		return restTemplate
				.exchange("http://localhost:8085/delete-user" + id, HttpMethod.DELETE, entity, UserResponse.class)
				.getBody();

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
