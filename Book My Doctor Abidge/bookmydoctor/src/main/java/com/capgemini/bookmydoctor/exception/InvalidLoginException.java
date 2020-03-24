package com.capgemini.bookmydoctor.exception;

public class InvalidLoginException extends RuntimeException {

	String msg;
	
	public InvalidLoginException() {
		super();
	}

	public InvalidLoginException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
		public String getMessage() {
			
			return this.msg;
		}
	
}
