package com.capgemini.collection.queueconcept;

import java.util.Collection;
import java.util.TreeSet;

public class TestEmployee {
public static void main(String[] args) {
	TreeSet<Employee> e1=new TreeSet<>(new SortEmpId());
	e1.add(new Employee(34, "Ram"));
	e1.add(new Employee(7, "Mike"));
	e1.add(new Employee(94, "Mohan"));
	e1.add(new Employee(14, "Jamy"));
	System.out.println(e1);
	
}
}
