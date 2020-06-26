package com.capgemini.bookmydoctor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public User getUser(String username) {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> query = manager.createQuery("select u from User u where u.email=:email", User.class);
		query.setParameter("email", username);
		User user = query.getSingleResult();
		manager.close();
		return user;
	}
	

}
