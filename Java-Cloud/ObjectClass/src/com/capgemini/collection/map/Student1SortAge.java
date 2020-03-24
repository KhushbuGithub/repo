package com.capgemini.collection.map;

import java.util.Comparator;

public class Student1SortAge  implements Comparator<Student1>{
	public static void main(String[] args) {
		
	}

	@Override
	public int compare(Student1 o1, Student1 o2) {
		return o1.age-o2.age;
	}

}
