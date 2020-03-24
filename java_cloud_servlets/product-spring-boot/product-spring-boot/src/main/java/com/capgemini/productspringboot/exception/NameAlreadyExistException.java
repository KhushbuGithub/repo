package com.capgemini.productspringboot.exception;

public class NameAlreadyExistException extends RuntimeException {
	public NameAlreadyExistException(String msg) {
		super(msg);
	}

}
