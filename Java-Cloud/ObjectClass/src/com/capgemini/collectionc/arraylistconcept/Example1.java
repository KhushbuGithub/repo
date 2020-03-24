package com.capgemini.collectionc.arraylistconcept;

import java.util.ArrayList;

public class Example1 {
	public static void main(String[] args) {
		ArrayList<Long> a1= new ArrayList<Long>();
		a1.add(7890654l);
		a1.add(678008754l);
		System.out.println(a1);
		
		ArrayList<Long> a2= new ArrayList<Long>();
		a2.add(789l);
		a2.add(98l);
		a2.add(7890654l);
		System.out.println(a2);
		a2.retainAll(a1);
		System.out.println(a2);
		
		
	}
	

}
