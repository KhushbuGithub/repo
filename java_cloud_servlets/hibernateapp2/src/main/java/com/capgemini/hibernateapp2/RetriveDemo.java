package com.capgemini.hibernateapp2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.hibernateapp2.dto.Movie;

public class RetriveDemo {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		Movie result = manager.find(Movie.class, 71);
		System.out.println(result.getId());
		System.out.println(result.getName());
		System.out.println(result.getRating());
		manager.close();
		factory.close();
	}

}
