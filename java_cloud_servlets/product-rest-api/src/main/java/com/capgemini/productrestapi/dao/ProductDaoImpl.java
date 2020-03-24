package com.capgemini.productrestapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.hibernate.cfg.PropertyInferredData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.productrestapi.dto.ProductInfoBean;

import lombok.extern.java.Log;


@Log
@Repository
public class ProductDaoImpl implements ProductDAO {
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@Override
	public boolean addProduct(ProductInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return false;
		}
	}

	@Override
	public boolean removeProduct(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			ProductInfoBean beans = manager.find(ProductInfoBean.class, id);
			manager.remove(beans);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return false;
		}
	}

	@Override
	public boolean updateProduct(ProductInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		ProductInfoBean beans = manager.find(ProductInfoBean.class, bean.getId());
		try {
			transaction.begin();
			beans.setPrice(bean.getPrice());
			manager.persist(beans);
			transaction.commit();
			return true;
		} catch (Exception e) {
			log.info(e.getMessage());
			for (StackTraceElement element : e.getStackTrace()) {
				log.info(element.toString());
			}
			return true;
		}
	}

	@Override
	public List<ProductInfoBean> getProductByName(String name) {
		EntityManager manager = factory.createEntityManager();
		String jpql ="select p from ProductInfoBean p where p.name=:name";
		TypedQuery<ProductInfoBean> query = manager.createQuery(jpql, ProductInfoBean.class);
		query.setParameter("name", name);
		List<ProductInfoBean> beans =	query.getResultList();
	    return beans;
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		EntityManager manager = factory.createEntityManager();
		String jpql ="select p from ProductInfoBean p";
		TypedQuery<ProductInfoBean> query = manager.createQuery(jpql, ProductInfoBean.class);
		List<ProductInfoBean> beans =	query.getResultList();
		return beans;
		
	}

}
