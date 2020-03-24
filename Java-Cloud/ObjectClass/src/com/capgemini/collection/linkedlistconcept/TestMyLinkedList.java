package com.capgemini.collection.linkedlistconcept;

public class TestMyLinkedList {
	public static void main(String[] args) {
		
	
	MyLinkedList<Integer> al= new MyLinkedList<Integer>();
	al.add(60);
	al.add(67);
	al.add(9);
	al.add(78);
	System.out.println(al);
	al.remove(9);
	System.out.println(al);

}
}