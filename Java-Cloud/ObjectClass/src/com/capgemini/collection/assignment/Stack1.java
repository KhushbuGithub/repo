package com.capgemini.collection.assignment;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class Stack1 {
	public static void main(String[] args) {
		Stack<Character> s1= new Stack<Character>();
		s1.add('A');
		s1.add('H');
		s1.add('P');
		s1.add('Y');
		s1.add('E');
		System.out.println(s1);
		System.out.println("-------------------------");
		for (int i = 0; i < s1.size(); i++) {
			System.out.println(s1.get(i));
		}
		System.out.println("----------------------------");
		for (Character c : s1) {
			System.out.println(c);
		}
		System.out.println("--------------------------");
		Iterator<Character> itr= s1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("-------------------------------");
		ListIterator<Character> ltr=s1.listIterator(s1.size());
		while(ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
	}
	

}
