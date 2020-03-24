package com.capgemini.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class TestStudent {
	public static void main(String[] args) {
		HashMap<Student,Integer> h1= new HashMap<Student,Integer>();
		h1.put( new Student(23, "ram"),1);
		h1.put( new Student(29, "om"),7);
		h1.put( new Student(34, "RAj"),9);
		h1.put( new Student(53, "Ajay"),3);
		
		Collection<Integer> c1=h1.values();
		for(Integer i:c1) {
			System.out.println(i);
		}
		
		Set<Student> s2= h1.keySet();
		for (Student student : s2) {
			System.out.println(student);
		}
		
		System.out.println("--------");
		Set<Entry<Student,Integer>> s1= h1.entrySet();
		for (Entry<Student,Integer> entry : s1) {
			System.out.println(entry);
			
		}
		
		System.out.println(h1.containsKey(new Student(23,"ram")));
		System.out.println(h1.containsValue(9));
		System.out.println(h1.get(new Student(34,"RAj")));
		
		
	}

}
