package com.capgemini.collection.assignment;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Vector1 {
	public static void main(String[] args) {
		Vector<Double> v1= new Vector<Double>();
		v1.add(988.0);
		v1.add(78.9);
		v1.add(45.7);
		v1.add(34.8);
		v1.add(34.7);
		System.out.println(v1);
		System.out.println("----------------------------------");
		
		for (int i = 0; i < v1.size(); i++) {
			System.out.println(v1.get(i));
			}
		System.out.println("-------------------------------------");
		
		for (Double d : v1) {
			System.out.println(d);
		}
		System.out.println("------------------------------------");
		Iterator<Double> itr= v1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("-------------------------------------");
		ListIterator<Double> ltr=v1.listIterator(v1.size());
		while(ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
	}

}
