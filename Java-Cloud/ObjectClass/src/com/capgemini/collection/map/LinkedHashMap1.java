package com.capgemini.collection.map;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

public class LinkedHashMap1 {
	public static void main(String[] args) {
		LinkedHashMap<Integer,String> l1=new LinkedHashMap<Integer,String>();
		l1.put(5, "shree");
		l1.put(7, "reo");
		l1.put(6, "shree");
		l1.put(null, null);
		
		Collection<String> c1=l1.values();
		for(String i:c1) {
			System.out.println(i);
		}
		System.out.println("-------------");
		Set<Integer> s2= l1.keySet();
		for (Integer a : s2) {
			System.out.println(a);
		}
		
		System.out.println("--------");
		Set <Entry<Integer,String>> s1= l1.entrySet();
		for (Entry<Integer,String> e : s1) {
			System.out.println(e);
			
		}
		System.out.println("---------------");
		System.out.println(l1.containsKey(7));
		System.out.println(l1.containsValue("shree"));
		System.out.println(l1.get(5));
		
	}

}
