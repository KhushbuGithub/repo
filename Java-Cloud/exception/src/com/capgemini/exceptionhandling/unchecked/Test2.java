package com.capgemini.exceptionhandling.unchecked;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("main started");
		String s=null;
		try {
			try {
				System.out.println(s.length());
			}catch(NullPointerException n){
				System.out.println(n.getMessage());
			}
			System.out.println(10/0);
		}catch(ArithmeticException a){
			System.out.println(a.getMessage());
		}
		System.out.println("main ended");
	}

}
