package com.capgemini.collection.queueconcept;

public class Employee {//implements Comparable<Employee>{
	int empId;
	String name;
	
//	@Override
//	public int compareTo(Employee o) {
//		if(this.empId<o.empId) {
//			return -1;
//		}
//		else if(this.empId>o.empId) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//	} 
	
	
	// OR
	
	
//	@Override
//	public int compareTo(Employee o) {
//		return this.empId-o.empId;
//	}
	
	//OR
	
//	@Override
//	public int compareTo(Employee o) {
//		return this.name.compareTo(o.name);
//	}
	
	
	
	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
	

}
