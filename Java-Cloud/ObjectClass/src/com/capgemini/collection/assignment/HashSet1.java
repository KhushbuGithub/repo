package com.capgemini.collection.assignment;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet1 {
	public static void main(String[] args) {
		HashSet<Byte> h1= new HashSet<Byte>();
		h1.add((byte) 78);
		h1.add((byte) 1234);
		h1.add((byte) 578);
		h1.add((byte) 3421);
		h1.add((byte) 1387);
		System.out.println(h1);
		System.out.println("----------------------------");
		for (Byte b : h1) {
			System.out.println(b);
		}
		System.out.println("--------------------------");
		Iterator<Byte> itr= h1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
