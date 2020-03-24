package com.capgemini.collection.map;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

public class TestEmp {
	public static void main(String[] args) {
		LinkedHashMap<Employee, String> l1= new LinkedHashMap<Employee,String>();
		l1.put(new Employee(34, "dff"), "hgjfsj");
		l1.put(new Employee(67, "hgh"), "hfhf");
		l1.put(new Employee(90, "hhsh"), "dgdhg");
		l1.put(new Employee(64, "err"), "khkg");
		
		Collection<String> c1=l1.values();
		for(String i:c1) {
			System.out.println(i);
		}
		System.out.println("--------------");
		Set<Employee> s2= l1.keySet();
		for (Employee s : s2) {
			System.out.println(s);
		}
		System.out.println("--------");
		Set<Entry<Employee, String>> s1= l1.entrySet();
		for (Entry<Employee,String> entry : s1) {
			System.out.println(entry);
			
		}
		System.out.println("--------------------");
		System.out.println(l1.containsKey(new Employee(67,"hgh")));
		System.out.println(l1.containsValue("khkg"));
		System.out.println(l1.get(new Employee(34,"dff")));
	    
		
		
	}

}
