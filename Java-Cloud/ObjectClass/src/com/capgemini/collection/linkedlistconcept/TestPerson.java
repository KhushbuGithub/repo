package com.capgemini.collection.linkedlistconcept;

import java.util.ArrayDeque;

import com.capgemini.collection.queueconcept.Person;
 
public class TestPerson {
	public static void main(String[] args) {
		ArrayDeque<Person> a1= new ArrayDeque<Person>();
		a1.add(new Person(23, "KHGGADD"));
		a1.add(new Person(56, "HI"));
		a1.add(new Person(21, "HI"));
		a1.add(new Person(56, "HI"));
		System.out.println(a1);
	}

}
