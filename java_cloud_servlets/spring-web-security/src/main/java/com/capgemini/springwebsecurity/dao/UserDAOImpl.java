package com.capgemini.springwebsecurity.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.springwebsecurity.bean.UserInfoBean;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean register(UserInfoBean userInfoBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx= manager.getTransaction();
		
		boolean isRegisterd= false;
		
		try {
			tx.begin();
			manager.persist(userInfoBean);
			tx.commit();
			isRegisterd= true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		manager.close();
		
		return isRegisterd;
		
	}

	@Override
	public UserInfoBean getUser(String username) {
		EntityManager manager= emf.createEntityManager();
		UserInfoBean userInfoBean=manager.find(UserInfoBean.class, username);
		manager.clear();
		
		return userInfoBean;
	}
	

}
