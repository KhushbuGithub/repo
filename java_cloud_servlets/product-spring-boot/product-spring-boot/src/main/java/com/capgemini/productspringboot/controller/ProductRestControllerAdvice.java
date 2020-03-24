package com.capgemini.productspringboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.productspringboot.dto.ProductResponse;
import com.capgemini.productspringboot.exception.NameAlreadyExistException;


@RestControllerAdvice
public class ProductRestControllerAdvice {
	@ExceptionHandler(NameAlreadyExistException.class)
	public ProductResponse emailAlreadyExist(NameAlreadyExistException e) {
		ProductResponse response= new ProductResponse();
		response.setStatuscode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}

}
