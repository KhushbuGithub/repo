package com.capgemini.bookmydoctor.exception;

public class UserException extends RuntimeException {

	String msg;

	public UserException() {
		super();
	}

	public UserException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {

		return msg;
	}
}
