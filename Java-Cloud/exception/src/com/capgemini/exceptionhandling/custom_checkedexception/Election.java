package com.capgemini.exceptionhandling.custom_checkedexception;

public class Election {
	//int age= 18;
	public void vote(int age) throws AgeLimitException {
		if (age<18) {
			throw new AgeLimitException();
		}else {
			System.out.println("Eligible to vote");
		}
		
	}

}
