package com.capgemini.collection.map;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TestStudent3 {
	public static void main(String[] args) {
		ArrayList<Student3> a1= new ArrayList<Student3>();
		a1.add(new Student3(34, "Ram"));
		a1.add(new Student3(67, "Ramesh"));
		a1.add(new Student3(90, "Ravi"));
		
		
		TreeMap<Student3, ArrayList<Student3>> t1= new TreeMap<Student3,ArrayList<Student3>>();
		t1.put(new Student3(67, "Heena"), a1);
		//t1.put(new Student3(97, "Meena"), a1);
		t1.put(new Student3(6, "Rita"), a1);
		
		Set<Entry<Student3,ArrayList<Student3>>> s1=t1.entrySet();
		for (Entry<Student3, ArrayList<Student3>> entry : s1) {
			System.out.println(entry);
			//System.out.println(entry.getValue());
			//System.out.println(entry.getKey());
		}
		
	}

}
