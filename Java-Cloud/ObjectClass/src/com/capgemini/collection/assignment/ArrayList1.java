package com.capgemini.collection.assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList1 {
	public static void main(String[] args) {
		ArrayList<String> a1= new ArrayList<String>();
		a1.add("Sita");
		a1.add("Gita");
		a1.add("Meet");
		a1.add("Reeta");
		System.out.println(a1);
		
		for (int i = 0; i < a1.size(); i++) {
			System.out.println(a1.get(i));
			}
		System.out.println("------------------------------------------------------");
		
		for (String s : a1) {
			System.out.println(s);
		}
		System.out.println("-----------------------------------------------------");
		Iterator<String> itr= a1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("----------------------------------------------------------");
		ListIterator<String> ltr=a1.listIterator(a1.size());
		while(ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
	}

}
