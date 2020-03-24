package com.capgemini.exceptionhandling.customuncheckedexception;

public class InSufficientBalanceException extends RuntimeException {
	String msg="Insufficient Balance";

	public InSufficientBalanceException() {
		
	}

	public InSufficientBalanceException(String msg) {
		super();
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
	}
	 
	
}
