package com.capgemini.javacloud.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.javacloud.dto.PatientResponse;
import com.capgemini.javacloud.exception.PatientException;

@RestControllerAdvice
public class PatientControllerAdvice {
	
	@ExceptionHandler(PatientException.class)
	public PatientResponse handleAdminException(PatientException e) {
		PatientResponse response = new PatientResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
