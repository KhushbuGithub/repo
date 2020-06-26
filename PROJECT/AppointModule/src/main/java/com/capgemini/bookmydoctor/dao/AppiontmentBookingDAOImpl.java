package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.AppiontmentBooking;
import com.capgemini.bookmydoctor.exception.UserException;

@Repository
public class AppiontmentBookingDAOImpl implements AppiontmentBookingDAO {
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addAppiontment(AppiontmentBooking appiontment) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		if(appiontment!=null) {
		try {
			transaction.begin();
			manager.persist(appiontment);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		}else {
			throw new UserException("field is empty");
		}
	}
	@Override
	public AppiontmentBooking searchAppiontment(int appiontmentId) {
		EntityManager manager = factory.createEntityManager();
		AppiontmentBooking appiontment  = manager.find(AppiontmentBooking.class, appiontmentId);
		return appiontment;
	}

	@Override
	public List<AppiontmentBooking> getAllAppiontments() {
		EntityManager manager = factory.createEntityManager();
		String getall="from AppiontmentBooking";
		TypedQuery<AppiontmentBooking> query=manager.createQuery(getall,AppiontmentBooking.class);
		return query.getResultList();
	}

	@Override
	public boolean deleteAppiontment(int appiontmentId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		AppiontmentBooking appiontment = manager.find(AppiontmentBooking.class, appiontmentId);
		if(appiontment != null) {
			transaction.begin();
			manager.remove(appiontment);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyAppiontment(AppiontmentBooking bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		AppiontmentBooking appiontment = manager.find(AppiontmentBooking.class, bean.getAppiontmentId());
		if(appiontment != null) {
			appiontment.setAppiontmentId(bean.getAppiontmentId());
			appiontment.setPatientName(bean.getPatientName());
			appiontment.setAge(bean.getAge());
			appiontment.setDiseaseSymptoms(bean.getDiseaseSymptoms());
			appiontment.setApproval(bean.getApproval());
			transaction.commit();
			manager.close();
			return true;
		}
		return false;
	}
	@Override
	public List<AppiontmentBooking> getAppiontments(int patientId) {
		List<AppiontmentBooking> list = new ArrayList<>();
		EntityManager manager = factory.createEntityManager();
		String getall="from AppiontmentBooking where patientId=:patientId";
		TypedQuery<AppiontmentBooking> query=manager.createQuery(getall,AppiontmentBooking.class);
		query.setParameter("patientId", patientId);
		list = query.getResultList();
		return list;
	}
	@Override
	public List<AppiontmentBooking> getAppiontmentsByName(String doctorName) {
		List<AppiontmentBooking> list = new ArrayList<>();
		EntityManager manager = factory.createEntityManager();
		String getall="from AppiontmentBooking where doctorName=:doctorName";
		TypedQuery<AppiontmentBooking> query=manager.createQuery(getall,AppiontmentBooking.class);
		query.setParameter("doctorName", doctorName);
		list = query.getResultList();
		return list;
	}

	}


