package com.capgemini.exceptionhandling.checked;

public class RunnerTest1 {
	public static void main(String[] args) {
		System.out.println("Main Started");
		Test1 t = new Test1();
		try {
			Class.forName("com.capgemini.exceptionhandling.checked.Test1");
			t.clone();
		}catch(ClassNotFoundException | CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}

}
