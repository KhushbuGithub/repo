package com.capgemini.collectionc.setconcept;

import java.util.HashSet;

public class HashSet1 {
	public static void main(String[] args) {
		HashSet<String> h1=new HashSet<String>();
		h1.add("Ea");
		h1.add(new String("joy"));
		h1.add("Fb");
		h1.add("joy");
		h1.add("90");
		h1.add(null);
		h1.add("joy");
		System.out.println(h1);
		System.out.println("Ea".hashCode());
		System.out.println("FB".hashCode());
		
	}

}
