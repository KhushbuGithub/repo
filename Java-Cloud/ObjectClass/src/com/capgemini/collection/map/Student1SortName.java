package com.capgemini.collection.map;

import java.util.Comparator;

public class Student1SortName implements Comparator<Student1>{
	public static void main(String[] args) {
		

	}
	@Override
	public int compare(Student1 o1, Student1 o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	
	}
}