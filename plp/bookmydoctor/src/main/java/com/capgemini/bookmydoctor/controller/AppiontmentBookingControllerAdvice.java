package com.capgemini.bookmydoctor.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.bookmydoctor.dto.AppiontmentBookingResponse;
import com.capgemini.bookmydoctor.dto.DoctorAvailablityResponse;
import com.capgemini.bookmydoctor.exception.AppiontmentBookingException;
import com.capgemini.bookmydoctor.exception.DoctorAvailablityException;

/**
 * 
 * @author BOBO
 * 
 * Handles the appintment relatede exception
 *
 */
@RestControllerAdvice
public class AppiontmentBookingControllerAdvice {
	
	@ExceptionHandler(AppiontmentBookingException.class)
	public AppiontmentBookingResponse handleAdminException(AppiontmentBookingException e) {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
