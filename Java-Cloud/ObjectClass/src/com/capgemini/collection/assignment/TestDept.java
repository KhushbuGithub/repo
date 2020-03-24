package com.capgemini.collection.assignment;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestDept{
	public static void main(String[] args) {
		LinkedHashSet<Department> l1= new LinkedHashSet<Department>();
		l1.add(new Department(6, "Accounting"));
		l1.add(new Department(1, "Finance"));
		l1.add(new Department(4, "Developing"));
		l1.add(new Department(2, "Testing"));
		l1.add(new Department(5, "Training"));
		l1.add(new Department(3, "Missleneous"));
		System.out.println(l1);
		System.out.println("----------------------------");
		for (Department d : l1) {
			System.out.println(d);
		}
		System.out.println("--------------------------");
		Iterator<Department> itr= l1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}

}