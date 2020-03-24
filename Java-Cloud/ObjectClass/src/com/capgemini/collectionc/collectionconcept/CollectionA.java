package com.capgemini.collectionc.collectionconcept;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionA {
	public static void main(String[] args) {
		Collection<Integer> c1=new ArrayList<Integer>();
		c1.add(34);
		c1.add(56);
		c1.add(45);
		c1.add(2);
		System.out.println(c1);
		
		c1.remove(56);
		System.out.println(c1);
		System.out.println(c1.size());
		
		System.out.println(c1.isEmpty());
		
		System.out.println(c1.contains(2));
		
	}

}
