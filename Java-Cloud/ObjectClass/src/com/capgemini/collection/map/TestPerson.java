package com.capgemini.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class TestPerson {
	public static void main(String[] args) {
		ArrayList<Person> a1= new ArrayList<Person>();
		a1.add(new Person(2000, "Jan"));
		a1.add(new Person(70000, "Feb"));
		a1.add(new Person(4000, "Mar"));
		a1.add(new Person(6000, "Apr"));
		
		HashMap<Integer, ArrayList<Person>> h1= new HashMap<Integer,ArrayList<Person>>();
		h1.put(67878, a1 );
		
		
		Set <Entry<Integer,ArrayList<Person>>> e1=h1.entrySet();{
			for (Entry<Integer, ArrayList<Person>> entry : e1) {
				System.out.println(entry);
			}
		}
		
	}

	

}
