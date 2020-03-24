package com.capgemini.exceptionhandling.unchecked;

public class Test1 {
public static void main(String[] args) {
	System.out.println("main started");
	String s= null;
	try {
		System.out.println(10/0);
		System.out.println(s.length());
	}catch(NullPointerException  | ArithmeticException e){
		System.out.println(e.getMessage());
	}
	
//		catch(ArithmeticException e) {
//		System.out.println("Cannot divide by zero");
//	}
	System.out.println(10/5);
	System.out.println("main ended");
}
}
