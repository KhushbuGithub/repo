package com.capgemini.exceptionhandling.exceptionpropagation;

public class TestA1 {
	public static void main(String[] args) {
		System.out.println("main starter");
     	try {
		A1.m();
		}catch(ArithmeticException e){
			System.out.println("cannot divide by 0");
		}
		System.out.println("main ended");
	}

}
