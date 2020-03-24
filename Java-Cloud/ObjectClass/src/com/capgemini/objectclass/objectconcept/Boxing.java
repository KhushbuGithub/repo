package com.capgemini.objectclass.objectconcept;

public class Boxing {
	public static void main(String[] args) {
		int a=6;
		Integer i=new Integer(a);  //autoboxing
		int j=i.intValue();        //unboxing
		
		System.out.println(i);
		System.out.println(j);
	}

}
