package com.capgemini.collection.assignment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList<Long> l1= new LinkedList<Long>();
		l1.add(988746474l);
		l1.add(9873663l);
		l1.add(956726445l);
		l1.add(745522662l);
		l1.add(567889988l);
		System.out.println(l1);
		System.out.println("----------------------------------------");
		for (int i = 0; i < l1.size(); i++) {
			
			System.out.println(l1.get(i));
		}
		System.out.println("----------------------------");
		for (Long l : l1) {
			System.out.println(l);
		}
		System.out.println("--------------------------");
		Iterator<Long> itr= l1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("-------------------------------");
		ListIterator<Long> ltr=l1.listIterator(l1.size());
		while(ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
	}

}
