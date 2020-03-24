package com.capgemini.collection.queueconcept;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueue1 {
	public static void main(String[] args) {
		PriorityQueue<Integer> p1= new PriorityQueue<Integer>();
		p1.add(23);
		p1.add(56);
		p1.add(78);
		p1.add(41);
		p1.add(90);
		p1.add(90);
		//p1.add(null);
		for(Integer integer:p1) {
			System.out.println(integer);
		}
		System.out.println(p1);
		p1.remove();      //removes the top element
		System.out.println(p1);
		
	Iterator<Integer> itr=  p1.iterator();
	while (itr.hasNext()) {
		System.out.println(itr.next());
	}
	}
}
