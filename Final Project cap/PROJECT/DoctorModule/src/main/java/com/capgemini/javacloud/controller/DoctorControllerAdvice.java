package com.capgemini.javacloud.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.javacloud.dto.DoctorResponse;
import com.capgemini.javacloud.exception.DoctorException;

@RestControllerAdvice
public class DoctorControllerAdvice {
	
	@ExceptionHandler(DoctorException.class)
	public DoctorResponse handleDoctorException(DoctorException e) {
		DoctorResponse response = new DoctorResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
