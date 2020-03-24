package com.capgemini.bookmydoctor.exception;

public class AdminException extends RuntimeException {

	String msg;

	public AdminException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
