package com.capgemini.collection.map;

import java.util.Map.Entry;
import java.util.Set;

public class HashMap1 {
	public static void main(String[] args) {
		java.util.HashMap<String, Integer> h1=new java.util.HashMap<String,Integer>();
		h1.put("Heena", 56);
		h1.put("Meena", 6);
		h1.put("Reeta", 21);
		h1.put("Hello", 56);
		h1.put(null, null);
		h1.put("Hello", 56);
		Set<Entry<String,Integer>> s1=h1.entrySet();
		for (Entry<String, Integer> e : s1) {
//			System.out.println(e);
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("-----------------------");
		}
	}
	

}
