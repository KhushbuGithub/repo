package com.capgemini.collection.queueconcept;

import java.util.Comparator;

public class SortEmpId implements Comparator<Employee>{
	public static void main(String[] args) {
		
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.empId-o2.empId;
	}

}
