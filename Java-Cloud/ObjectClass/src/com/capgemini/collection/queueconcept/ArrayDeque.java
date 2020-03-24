package com.capgemini.collection.queueconcept;

import java.util.Iterator;

public class ArrayDeque {
	public static void main(String[] args) {
		java.util.ArrayDeque<String> a1= new java.util.ArrayDeque<String>();
		a1.add("jhh");
		a1.add("jjfdgd");
		a1.add("ji");
		a1.add("ji");
		System.out.println(a1);
		a1.remove();
		System.out.println(a1);
		
		System.out.println("------for each------");
		for (String string : a1) {
			System.out.println(string);
		}
		System.out.println("------Iterator------");
		Iterator<String> itr =a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
