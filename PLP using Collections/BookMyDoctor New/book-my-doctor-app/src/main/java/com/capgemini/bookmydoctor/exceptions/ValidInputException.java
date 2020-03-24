package com.capgemini.bookmydoctor.exceptions;

public class ValidInputException extends RuntimeException {
	String msg;
	public ValidInputException() {
		this.msg="Exception:This Email-Id is Already Existing!!..";
	}
	public String getMsg() {
		return msg;
	}

}
