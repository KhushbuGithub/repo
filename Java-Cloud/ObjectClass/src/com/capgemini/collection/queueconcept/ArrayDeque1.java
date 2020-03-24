package com.capgemini.collection.queueconcept;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDeque1 {
	public static void main(String[] args) {
		ArrayDeque<Double> a1= new ArrayDeque<Double>();
		a1.add(34.7);
		a1.add(45.8);
		a1.add(3.0);
		a1.add(56.9);
		a1.add(34.7);
		System.out.println(a1);
		a1.remove();
		System.out.println(a1);
		
		for (Double d : a1) {
			System.out.println(d);	
		}
		System.out.println("------------");
		
		Iterator<Double> itr = a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
