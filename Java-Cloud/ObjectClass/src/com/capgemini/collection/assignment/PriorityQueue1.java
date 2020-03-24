package com.capgemini.collection.assignment;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class PriorityQueue1 {
	public static void main(String[] args) {
		PriorityQueue<Float> p1= new PriorityQueue<Float>();
		p1.add(87677f);
		p1.add(56777f);
		p1.add(78999f);
		p1.add(134588f);
		p1.add(34568f);
		System.out.println(p1);
		System.out.println("----------------------------------------");
		
		for (Float f : p1) {
			System.out.println(f);
		}
		System.out.println("--------------------------");
		Iterator<Float> itr= p1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
