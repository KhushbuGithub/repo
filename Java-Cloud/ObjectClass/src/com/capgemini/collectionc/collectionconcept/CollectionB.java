package com.capgemini.collectionc.collectionconcept;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionB {
	public static void main(String[] args) {
		Collection<Integer> c1=new ArrayList<Integer>();
		c1.add(12);
		c1.add(45);
		c1.add(54);
		Collection<Integer> c2=new ArrayList<Integer>();
		c2.add(12);
		c2.add(45);
		c2.add(59);
		c2.add(87);
		System.out.println(c1);
		c1.addAll(c2);            //to add all the elements
		System.out.println(c1);
		c1.removeAll(c2);         //to remove all the elements
		System.out.println(c1);
		System.out.println(c1.containsAll(c2));     //check weather all elements are present or not

		
		Collection<Integer> c3=new ArrayList<Integer>();
		c3.add(12);
		c3.add(45);
		c3.add(54);
		Collection<Integer> c4=new ArrayList<Integer>();
		c4.add(12);
		c4.add(45);
		c4.add(76);
		c4.add(59);
		c4.add(34);
		System.out.println(c4);
		System.out.println(c3);
		System.out.println("------------------");
		c4.retainAll(c3);        //to print the common value
		System.out.println(c4);
		System.out.println(c3);
		Object[] o1=c3.toArray();  
		for (int i = 0; i < o1.length; i++) {
			System.out.println(o1[i]);
		}
	}

}
