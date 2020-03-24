package com.capgemini.collection.assignment;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestCar {
	public static void main(String[] args) {
		LinkedHashSet<Car> l1= new LinkedHashSet<Car>();
		l1.add(new Car("BMW", 5));
		l1.add(new Car("Aulto", 1));
		l1.add(new Car("Mercedez", 4));
		l1.add(new Car("Duster", 3));
		l1.add(new Car("Swift", 2));
		System.out.println(l1);
		System.out.println("------------------------------");
		for (Car c : l1) {
			System.out.println(c);
		}
		System.out.println("----------------------------------");
		Iterator<Car> itr=l1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
