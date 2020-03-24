package com.capgemini.objectclass.objectconcept;

public class Employee implements Cloneable {
	String compName;
	double salary;
	
	public Employee(String compName, double salary) {
		super();
		this.compName = compName;
		this.salary = salary;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee[compName="+compName+",salary="+salary+"]";
	}
	
		
	
	

}
