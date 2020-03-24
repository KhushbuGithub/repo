package com.capgemini.bookmydoctor.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.bookmydoctor.dto.PatientResponse;
import com.capgemini.bookmydoctor.exception.PatientException;

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
