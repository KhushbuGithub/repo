package com.capgemini.collection.queueconcept;

import java.util.Comparator;

public class SortName implements Comparator<Employee>{
	public static void main(String[] args) {
		
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.name.compareTo(o2.name);
	}

}
