package com.capgemini.collectionc.arraylistconcept;

import java.util.ArrayList;

public class ArrayList1 {
public static void main(String[] args) {
	ArrayList<Integer> a1= new ArrayList<Integer>();
	a1.add(10);
	a1.add(20);
	a1.add(30);
	a1.add(10);
	a1.add(1, null);
	System.out.println(a1);
	System.out.println("------------remove at index-------------");
	a1.remove(2);
	System.out.println(a1);
	a1.set(2, 100);
	System.out.println(a1);
	System.out.println(a1.indexOf(10));
	System.out.println(a1.lastIndexOf(10));
	a1.remove(new Integer(10));
	System.out.println(a1);
	System.out.println("--------------------------");
	for (int i = 0; i < a1.size(); i++) {
		System.out.println(a1.get(i));
	}
	a1.retainAll(a1);
	System.out.println(a1);
}
}
