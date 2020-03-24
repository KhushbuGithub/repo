package com.capgemini.exceptionhandling.checked;

public class TestEmployee {
	public static void main(String[] args) {
		System.out.println("Main Started");
		Employee e1= new Employee();
		try {
//			Class.forName("Employee");
			Class.forName("com.capgemini.exceptionhandling.checked.Employee");
			e1.clone();
		}catch(ClassNotFoundException c) {
			System.out.println("class not found");
		}catch(CloneNotSupportedException n) {
			System.out.println("object cannot be cloned");
		}
		System.out.println("main ended");
	}

}
