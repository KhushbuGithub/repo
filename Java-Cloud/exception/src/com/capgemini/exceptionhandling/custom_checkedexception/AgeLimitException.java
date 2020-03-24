package com.capgemini.exceptionhandling.custom_checkedexception;

public class AgeLimitException extends Exception {
	String msg= "Age is less than 18";

	public AgeLimitException() {
		super();
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
	

}
