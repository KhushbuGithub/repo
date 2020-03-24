package com.capgemini.springboot.exception;

public class EmailAlreadyExistException extends RuntimeException {
public EmailAlreadyExistException(String msg) {
	super(msg);
}
}
 