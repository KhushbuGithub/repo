package com.capgemini.objectclass.objectconcept;

public class StringClass {
public static void main(String[] args) {
	String s1= new String ("MY");
	String s2= new String ("MY");
	System.out.println(s1);
	System.out.println(s2);
	String s3= "John";
	String s4 ="John";
	System.out.println(s3);
	System.out.println(s4);
	
	
	s3=s3.concat(s1);
	System.out.println(s3);
}
}
