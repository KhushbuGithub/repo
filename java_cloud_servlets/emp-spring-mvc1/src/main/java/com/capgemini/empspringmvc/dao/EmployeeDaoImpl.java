package com.capgemini.empspringmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.empspringmvc.dto.EmployeeInfoBean;

import lombok.extern.java.Log;

@Log
@Repository
public class EmployeeDaoImpl implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public EmployeeInfoBean auth(String email, String password) {
		String jpql = "select e from EmployeeInfoBean e where e.email=:email";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<EmployeeInfoBean> query = manager.createQuery(jpql, EmployeeInfoBean.class);
		query.setParameter("email", email);
		try {
			EmployeeInfoBean bean = query.getSingleResult();
			if (encoder.matches(password, bean.getPassword())) {
				return bean;
			} else {
				return null;
			}
		} catch (Exception e) {

			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return null;
		}
	}

	@Override
	public boolean register(EmployeeInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transation = manager.getTransaction();
		transation.begin();
		try {
			// String password=bean.getPassword();
			// String encodedPassword=encoder.encode(bean.getPassword());
			bean.setPassword(encoder.encode(bean.getPassword()));
			manager.persist(bean);
			transation.commit();
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
		}
		return false;
	}

	@Override
	public void changePassword(int id, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transation = manager.getTransaction();
		transation.begin();
		EmployeeInfoBean bean = manager.find(EmployeeInfoBean.class, id);
		bean.setPassword(encoder.encode(password));
		manager.persist(bean);
		transation.commit();
	}

	@Override
	public List<EmployeeInfoBean> search(String name) {
		String jpql = "select e form EmployeeInfoBean e where e.name=:name";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<EmployeeInfoBean> query = manager.createQuery(jpql, EmployeeInfoBean.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

}
