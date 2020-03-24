package com.capgemini.objectclass.objectconcept;

public class Student {
	public static void main(String[] args) {
		Test t= new Test(7, "john");
		System.out.println(t.hashCode());
		Test t2=new Test(6, "mike");
		System.out.println(t2.hashCode());
		
		 Class c1=t.getClass();
		 System.out.println(c1);
		 Integer i1=new Integer(56);
		 Class c2=i1.getClass();
		 System.out.println(c2);
		 
		 String s1=t.toString();
	     System.out.println(s1);
	 
	 
		int a=38;
		int b=38;
		System.out.println(a==b);
		Integer n1=new Integer(70);
		Integer n2=new Integer(70);
		System.out.println(n1==n2);
		System.out.println(n1.equals(n2));
		
		Test r1=new Test(34, "yolo");
		Test r2= new Test(34,"yolo");
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		System.out.println(r1==r2);
		System.out.println(r1.equals(r2));
		
	}

}
