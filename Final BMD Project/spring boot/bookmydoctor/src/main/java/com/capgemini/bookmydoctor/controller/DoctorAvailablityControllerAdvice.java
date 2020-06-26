package com.capgemini.bookmydoctor.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.bookmydoctor.dto.DoctorAvailablityResponse;
import com.capgemini.bookmydoctor.exception.DoctorAvailablityException;

@RestControllerAdvice
public class DoctorAvailablityControllerAdvice {
	
	@ExceptionHandler(DoctorAvailablityException.class)
	public DoctorAvailablityResponse handleDoctorAvailabilityException(DoctorAvailablityException e) {
		DoctorAvailablityResponse response = new DoctorAvailablityResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
