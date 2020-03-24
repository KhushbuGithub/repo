package com.capgemini.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.springboot.dto.EmployeeResponse;
import com.capgemini.springboot.exception.EmailAlreadyExistException;

@RestControllerAdvice
public class EmployeeRestControllerAdvice {
	@ExceptionHandler(EmailAlreadyExistException.class)
	public EmployeeResponse emailAlreadyExist(EmailAlreadyExistException e) {
		EmployeeResponse response= new EmployeeResponse();
		response.setStatuscode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
