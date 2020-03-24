package com.capgemini.collectionc.vectorconcept;

import java.util.Vector;

public class Vector1 {
public static void main(String[] args) {
	Vector<Integer> v1= new Vector<Integer>();
	v1.add(0, 45);
	v1.add(1, 90);
	v1.add(2, 67);
	v1.add(3, null);
	v1.add(4, 90);
	System.out.println(v1);
	v1.setElementAt(34, 4);
	System.out.println(v1);
	v1.removeElementAt(0);
	System.out.println(v1);
	v1.removeElement(new Integer(67));
	System.out.println(v1);
	 
	System.out.println(v1.capacity());
	System.out.println(v1.size());
	
	v1.setSize(4);
	System.out.println(v1);
	
	v1.trimToSize();
	System.out.println(v1.capacity());
	v1.ensureCapacity(15);
	System.out.println(v1.capacity());
	System.out.println(v1.size());
	
	v1.trimToSize();
	System.out.println(v1.capacity());
	v1.ensureCapacity(12);
	System.out.println(v1.capacity());
	System.out.println(v1.size());
	
	System.out.println(v1);
	System.out.println(v1.firstElement());


	}
}
