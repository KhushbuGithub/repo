package com.capgemini.javacloud.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.javacloud.dto.UserResponse;
import com.capgemini.javacloud.exception.UserException;


@RestControllerAdvice
public class UserControllerAdvice {
	
	@ExceptionHandler(UserException.class)
	public UserResponse handleUserException(UserException e) {
		UserResponse response = new UserResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
