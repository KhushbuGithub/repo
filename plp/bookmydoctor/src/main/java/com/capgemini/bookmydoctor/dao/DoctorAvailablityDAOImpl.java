package com.capgemini.bookmydoctor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.DoctorAvailablity;

@Repository
public class DoctorAvailablityDAOImpl implements DoctorAvailablityDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addDoctorAvailability(DoctorAvailablity bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		transaction.commit();
		entityManager.close();
		return false;
	}

	@Override
	public boolean deleteDoctorAvailability(int availabilityId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		DoctorAvailablity bean = manager.find(DoctorAvailablity.class, availabilityId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<DoctorAvailablity> getAllDoctorAvailabilities() {
		String jpql = "from DoctorAvailabilityBean";
		EntityManager manager = entityManagerFactory.createEntityManager();
		TypedQuery<DoctorAvailablity> query = manager.createQuery(jpql, DoctorAvailablity.class);

		return query.getResultList();
	}

	@Override
	public DoctorAvailablity searchDoctorAvailability(int availabilityId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		DoctorAvailablity searchAvailability = manager.find(DoctorAvailablity.class, availabilityId);
		return searchAvailability;
	}

	@Override
	public boolean modifyDoctorAvailability(DoctorAvailablity bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		DoctorAvailablity doctorAvailability = entityManager.find(DoctorAvailablity.class,
				bean.getAvailabilityId());
		if (doctorAvailability != null) {
			doctorAvailability.setAvailabilityId(bean.getAvailabilityId());
			doctorAvailability.setDoctorId(bean.getDoctorId());
			doctorAvailability.setFromDate(bean.getFromDate());
			doctorAvailability.setToDate(bean.getToDate());
			transaction.commit();
			entityManager.close();
			return true;
		}
		return false;
	}


	
	
}
