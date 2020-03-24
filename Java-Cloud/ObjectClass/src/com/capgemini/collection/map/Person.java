package com.capgemini.collection.map;

public class Person {
	int salary;
	String month;
	
	public Person(int salary, String month) {
		super();
		this.salary = salary;
		this.month = month;
	}

	@Override
	public String toString() {
		return "Person [salary=" + salary + ", month=" + month + "]";
	}
	
	

}
