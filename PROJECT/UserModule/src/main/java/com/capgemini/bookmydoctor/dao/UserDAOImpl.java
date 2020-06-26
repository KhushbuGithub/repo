package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.exception.UserException;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addUser(User user) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			manager.close();
			return true;
		} catch (Exception e) {
			manager.close();
			return false;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		EntityManager manager = factory.createEntityManager();
		String getall = "from User";
		TypedQuery<User> query = manager.createQuery(getall, User.class);
		list = query.getResultList();
		manager.close();
		return list;
	}

	@Override
	public boolean deleteUser(int userId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		User user = manager.find(User.class, userId);
		if (user != null) {
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean changePassword(int userId, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		User user2 = manager.find(User.class, userId);
		user2.setPassword(password);
		transaction.commit();
		return true;
	}

	public User login(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from User where email=:email ";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("email", email);
		try {
			User bean = query.getSingleResult();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, bean.getPassword())) {
				manager.close();
				return bean;
			} else {
				manager.close();
				throw new UserException("password invalid");
			}
		} catch (Exception e) {
			e.printStackTrace();
			manager.close();
			throw new UserException("Invalid credentials please try again!");
		}
	}

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
