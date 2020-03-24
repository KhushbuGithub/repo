package com.capgemini.objectclass.objectconcept;

public class TestC {
	public static void main(String[] args) {
		Person p=new Person("Sita", 89);
		p=null;
		System.gc();
		System.out.println("main ended");
	}

}
