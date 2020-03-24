package com.capgemini.exceptionhandling.unchecked;

public class TestException {
	public static void main(String[] args) {
		System.out.println("main started");
		try {
			System.out.println(10/0);
		}catch(ArithmeticException e){
			System.out.println("Math Error");
		}
		System.out.println(10/5);
		System.out.println("main ended");
	}

}
