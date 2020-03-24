package com.capgemini.collectionc.vectorconcept;

import java.util.Stack;

public class Stack1 {
	public static void main(String[] args) {
		Stack<Integer> s1= new Stack<Integer>();
		s1.push(23);
		s1.push(56);
		s1.add(569);
		s1.push(null);
		s1.push(89);
		System.out.println(s1);
		s1.pop();
		System.out.println(s1);
		System.out.println(s1.search(56)); //to count the element postion from the last
		System.out.println(s1.peek());
	}

}
