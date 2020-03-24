package com.capgemini.collection.linkedlistconcept;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class List_IteratingWays {
	public static void main(String[] args) {
		ArrayList<Integer> a1= new ArrayList<Integer>();
		a1.add(45);
		a1.add(90);
		a1.add(56);
		a1.add(50);
		System.out.println("-----for loop------");
		for (int i = 0; i < a1.size(); i++) {
			System.out.println(a1.get(i));
			
		}
		System.out.println("-----for each-----");
		for (Integer i : a1) {
			System.out.println(i);
			
		}
		System.out.println("----iterator-----");
		Iterator<Integer> itr=a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("-----list_Iterator------");
		ListIterator<Integer> litr=a1.listIterator();
		while(litr.hasNext()) {
			System.out.println(litr.next());
		}
		System.out.println("-----list Iterator in backward direction-----");
		ListIterator<Integer> lit =a1.listIterator(a1.size());
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
	}

}
