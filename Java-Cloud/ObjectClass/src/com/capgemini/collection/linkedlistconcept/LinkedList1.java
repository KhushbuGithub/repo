package com.capgemini.collection.linkedlistconcept;

import java.util.LinkedList;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList<Integer> l1= new LinkedList<Integer>();
		l1.add(23);
		l1.addFirst(45);
		l1.addLast(67);
		l1.add(78);
		l1.add(90);
		l1.add(45);
		System.out.println(l1);
		
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		l1.offer(69);     //add element at last
		l1.offerFirst(21);   //add element at first
		System.out.println(l1);
		l1.poll();           //remove element from first
		System.out.println(l1);
		l1.peekLast();
		System.out.println(l1);
		System.out.println(l1.peek());
		System.out.println(l1.peekLast());
		System.out.println(l1);
		l1.pop();
		System.out.println(l1);
		l1.removeFirstOccurrence(45);
		l1.removeLastOccurrence(23);
		System.out.println(l1);
	}

}
