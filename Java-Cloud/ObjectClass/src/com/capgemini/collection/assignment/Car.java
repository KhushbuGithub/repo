package com.capgemini.collection.assignment;

public class Car  {
	String name;
	int rating;
	
	public Car(String name, int rating) {
		super();
		this.name = name;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", rating=" + rating + "]";
	}
	
	

}
