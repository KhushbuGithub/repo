package com.capgemini.objectclass.objectconcept;

public class TestString1 {
	public static void main(String[] args) {
		StringBuffer s1= new StringBuffer("Mike");
		StringBuffer s2=new StringBuffer("Jakson");
		s1.append("al");
		s2.append("SOSOSOS");
		System.out.println(s1);
		System.out.println(s2);
		
		StringBuilder s3= new StringBuilder("Son");
		s3.append("Maya");
		System.out.println(s3);
	}

}
