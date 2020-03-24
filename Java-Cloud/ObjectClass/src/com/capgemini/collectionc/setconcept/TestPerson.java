package com.capgemini.collectionc.setconcept;

import java.util.LinkedHashSet;

public class TestPerson {
	public static void main(String[] args) {
		LinkedHashSet<Person> p1=new LinkedHashSet<Person>();
		p1.add(new Person(12,"ram"));
		p1.add(new Person(12,"ram"));
		p1.add(new Person(89,"hhdh"));
		p1.add(new Person(129,"hdjjd"));
		p1.add(new Person(812,"FAm"));
		p1.add(new Person(612,"rani"));
		p1.add(new Person(2,"ramyan"));
		p1.add(null);
		System.out.println(p1);
		for (Person p : p1) {
			System.out.println(p);
			
		}
	}

}
