package com.capgemini.objectclass.objectconcept;

public class Person {
	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	protected void finalize() throws Throwable {
		
	System.out.println("Finalize method");
	}
}
