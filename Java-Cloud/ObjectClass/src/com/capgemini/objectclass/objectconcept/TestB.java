package com.capgemini.objectclass.objectconcept;

public class TestB {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1=new Employee("DXC", 24455);
		Object o1=e1.clone();
		System.out.println(o1);
		System.out.println(e1);
	}

}
