package com.capgemini.collection.assignment;

public class Student implements Comparable<Student>{
	int marks;
	String Sub;
	
	public Student(int marks, String sub) {
		super();
		this.marks = marks;
		Sub = sub;
	}

	@Override
	public String toString() {
		return "Student [marks=" + marks + ", Sub=" + Sub + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.marks-o.marks;
	}
	
	

}
