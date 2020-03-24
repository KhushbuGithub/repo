package com.capgemini.collection.map;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestStudent1 {
	public static void main(String[] args) {
		TreeMap<Student1, Integer> t1= new TreeMap<Student1,Integer>(new Student1SortAge());
		t1.put(new Student1(67, "Aam"), 1);
		t1.put(new Student1(9, "Ram"), 1);
		t1.put(new Student1(7, "Shyam"), 19);
		
		Set<Entry<Student1, Integer>> s1=t1.entrySet();
		for (Entry<Student1, Integer> entry : s1) {
			System.out.println(entry);
			System.out.println("---------------------");
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
			//System.out.println("-------------------------");
		}
		
		
	}

}
