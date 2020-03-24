package com.capgemini.collection.queueconcept;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TestStudent {
	public static void main(String[] args) {
		PriorityQueue<Student> p1=new PriorityQueue<Student>();
		p1.add(new Student(21, "Ram"));
		p1.add(new Student(46, "Shyam"));
		p1.add(new Student(67, "Mike"));
		p1.add(new Student(1, "Ram"));
		System.out.println(p1);
		Iterator<Student> itr=  p1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
}
