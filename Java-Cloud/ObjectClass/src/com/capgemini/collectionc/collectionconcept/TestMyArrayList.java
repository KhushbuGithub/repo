package com.capgemini.collectionc.collectionconcept;

public class TestMyArrayList {
	public static void main(String[] args) {
		MyArrayList<Integer> al=new MyArrayList<Integer>();
		al.add(34);
		al.add(36);
		al.add(45);
		al.add(78);
		al.add(90);
		al.add(12);
		al.add(13);
		al.add(21);
		System.out.println(al);
		//al.details();
		
		al.remove(2);
		al.remove(2);
		//al.details();
		System.out.println(al);
	}

}
