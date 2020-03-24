package com.capgemini.exceptionhandling.checked;

public class TestPerson {
	public static void main(String[] args) {
		System.out.println("main started");
		PersonClone p= new PersonClone();
		try {
			p.clone();
			System.out.println("object is cloned");
		}catch(CloneNotSupportedException e) {
			System.out.println("Clone not supported");
		}
		System.out.println("main ended");
	}

}
