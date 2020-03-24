package com.capgemini.collectionc.collectionconcept;

public class TestB {
	
		public static void main(String[] args) {
			MyArrayList<Integer> al=new MyArrayList<Integer>();
			al.add(34);
			al.add(36);
			al.add(45);
			System.out.println(al);
			al.details();
			al.remove(45);
			System.out.println(al);
		}

	}

