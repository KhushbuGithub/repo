package com.capgemini.exceptionhandling.exceptionpropagation;

public class TestA {
	public static void main(String[] args) {
		try {
		A.m();
		}catch(ClassNotFoundException e) {
			System.out.println("class not found");
		}
	}

}
