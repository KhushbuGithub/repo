package com.capgemini.objectclass.objectconcept;

public class TestString {
	public static void main(String[] args) {
		String s1=new String("Monkey King");
		s1=s1.toLowerCase();
		System.out.println(s1);
		int s2=s1.length();
		System.out.println(s2);
		String s3=s1.replace('o', 'L');
		System.out.println(s3);
		char s4=s1.charAt(7);
		System.out.println(s4);
		
	}

}
