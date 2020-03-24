package com.capgemini.springrestsecurity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springrestsecurity.beans.UserInfoBean;

import lombok.extern.java.Log;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public boolean register(UserInfoBean userInfoBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		boolean isRegisterd = false;

		try {
			tx.begin();
			manager.persist(userInfoBean);
			tx.commit();
			isRegisterd = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isRegisterd;

	}

	public UserInfoBean getUser(String username) {
		EntityManager manager = emf.createEntityManager();
		UserInfoBean userInfoBean = manager.find(UserInfoBean.class, username);
		manager.clear();

		return userInfoBean;
	}

	public List<UserInfoBean> getAllUsers() {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery("from UserInfoBean");
		List<UserInfoBean> usersList = query.getResultList();
		manager.close();
		return usersList;
	}

}
