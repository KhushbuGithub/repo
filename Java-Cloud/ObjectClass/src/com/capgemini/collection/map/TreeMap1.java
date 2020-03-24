package com.capgemini.collection.map;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {
	public static void main(String[] args) {
		TreeMap<Integer, String> t1= new TreeMap<Integer,String>();
		t1.put(5, "anu");
		t1.put(1, "Monu");
		t1.put(8, "Shree");
		t1.put(4, "ANUAU");
		
		Set<Entry<Integer,String>> s1=t1.entrySet();
		for (Entry<Integer, String> entry : s1) {
			System.out.println(entry);
			System.out.println("---------------------------");
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
		}
		Set<Integer> s2=t1.keySet();
		for (Integer integer : s2) {
			System.out.println(integer);
		}
		Collection<String> c1=t1.values();
		for (String string : c1) {
			System.out.println(string);
		}
		System.out.println(t1.containsKey(1));
		System.out.println(t1.containsValue("Shree"));
		System.out.println(t1.get(4));
		}

}
