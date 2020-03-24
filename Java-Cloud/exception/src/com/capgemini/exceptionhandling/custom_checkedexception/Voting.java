package com.capgemini.exceptionhandling.custom_checkedexception;

public class Voting {
 public static void main(String[] args) throws AgeLimitException {
	System.out.println("main started");
	Election e2= new Election();
	try {
		e2.vote(17);
	} catch (AgeLimitException e) {
		System.out.println(e.getMessage());
	}
}
}
