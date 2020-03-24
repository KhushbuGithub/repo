package com.capgemini.collection.map;

public class Student3 implements Comparable<Student3>{
	int marks;
	String name;
	public Student3(int marks, String name) {
		super();
		this.marks = marks;
		this.name = name;
	}
	@Override
	public String toString() {
		return marks+" " +name;
	}
	@Override
	public int compareTo(Student3 o) {
		return this.name.compareTo(o.name);
	}
	 

}
