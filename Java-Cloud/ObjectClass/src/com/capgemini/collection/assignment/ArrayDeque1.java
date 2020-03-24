package com.capgemini.collection.assignment;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDeque1 {
	public static void main(String[] args) {
		ArrayDeque<Short> a1= new ArrayDeque<Short>();
		a1.add((short) 6788);
		a1.add((short) 8767);
		a1.add((short) 7889);
		a1.add((short) 9876);
		System.out.println(a1);
		System.out.println("----------------------------");
		for (Short s : a1) {
			System.out.println(s);
		}
		System.out.println("--------------------------");
		Iterator<Short> itr= a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

