package com.capgemini.streamapi.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestA {
	public static void main(String[] args) {
		 ArrayList<Integer> a1= new ArrayList<Integer>();
		 a1.add(34);
		 a1.add(67);
		 a1.add(67);
		 a1.add(89);
		 a1.add(4);
		 a1.add(12);
		 a1.add(90);
		 
		 List<Integer> l1= a1.stream().filter(i ->(i%2)==0).collect(Collectors.toList());
		 for (Integer integer : l1) {
			System.out.println(integer);
		}
		 System.out.println("------------------------");
		 List<Integer> l= a1.stream().filter(i ->(i%2)!=0).collect(Collectors.toList());
		 for (Integer integer : l) {
			System.out.println(integer);
		}
		 
		 System.out.println("------------------------------");
		 List<Integer> l2=a1.stream().map(i -> (i-1)).collect(Collectors.toList());
		 for (Integer integer : l2) {
			System.out.println(integer);
		}
		
	}

}
