package com.capgemini.collection.assignment;

import java.util.Iterator;
import java.util.TreeSet;

public class TestStudent {
	public static void main(String[] args) {
		TreeSet<Student> t1= new TreeSet<Student>();
		t1.add(new Student(45, "Maths"));
		t1.add(new Student(95, "Science"));
		t1.add(new Student(80, "Hindi"));
		t1.add(new Student(32, "CS"));
		t1.add(new Student(56, "Urdu"));
		System.out.println(t1);
		System.out.println("----------------------------");
		for (Student s : t1) {
			System.out.println(s);
		}
		System.out.println("--------------------------");
		Iterator<Student> itr= t1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
