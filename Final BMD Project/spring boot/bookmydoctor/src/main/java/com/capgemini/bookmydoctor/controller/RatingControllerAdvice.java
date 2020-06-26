package com.capgemini.bookmydoctor.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.bookmydoctor.dto.RatingResponse;
import com.capgemini.bookmydoctor.exception.RatingException;

@RestControllerAdvice
public class RatingControllerAdvice {
	
	@ExceptionHandler(RatingException.class)
	public RatingResponse handleRatingException(RatingException e) {
		RatingResponse response = new RatingResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
