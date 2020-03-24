package com.capgemini.collection.map;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class TestEmpLHM {
	public static void main(String[] args) {
		LinkedList<Employee> ll= new LinkedList<Employee>();
		ll.add(new Employee(6, "hhh"));
		ll.add(new Employee(5, "ppp"));
		ll.add(new Employee(4, "iii"));
		ll.add(new Employee(3, "kkh"));
		 
		LinkedHashMap<Integer,LinkedList<Employee>> l2= new LinkedHashMap<Integer,LinkedList<Employee>>();
		l2.put(9, ll);
		l2.put(5, ll);
		
		Set<Integer> s1= l2.keySet();
		for (Integer integer : s1) {
			System.out.println(integer);
		}
		System.out.println("-------------------");
		Collection<LinkedList<Employee>> c=l2.values();
		for (LinkedList<Employee> l : c) {
			for (Employee e : l) {
				System.out.println(e);
			//	System.out.println("-----------------");
			}
		}
		
		
		
	}

}
