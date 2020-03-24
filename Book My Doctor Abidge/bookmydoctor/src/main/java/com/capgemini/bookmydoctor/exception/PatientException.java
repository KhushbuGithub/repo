package com.capgemini.bookmydoctor.exception;

public class PatientException extends RuntimeException {

	String msg;

	public PatientException() {
		super();
	}

	public PatientException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {

		return msg;
	}

}
