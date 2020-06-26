package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.User;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public boolean addDoctor(Doctor bean, int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		User user = manager.find(User.class, id);
		bean.setUser(user);
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteDoctor(int doctorId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Doctor bean = manager.find(Doctor.class, doctorId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		return false;
	}

	public List<Doctor> getAllDoctors() {
		String jpql = "select f from Doctor f";
		EntityManager manager = entityManagerFactory.createEntityManager();
		TypedQuery<Doctor> query = manager.createQuery(jpql, Doctor.class);
		return query.getResultList();
	}

	public boolean modifyDoctor(Doctor bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		Doctor doctor = entityManager.find(Doctor.class, bean.getUserId());
		if (doctor != null) {
			doctor.setUserId(bean.getUserId());
			doctor.setDoctorName(bean.getDoctorName());
			doctor.setGender(bean.getGender());
			doctor.setEmail(bean.getEmail());
			doctor.setAge(bean.getAge());
			doctor.setSpecialization(bean.getSpecialization());
			doctor.setLanguage1(bean.getLanguage1());
			doctor.setLanguage2(bean.getLanguage2());
			doctor.setHomeAddress(bean.getHomeAddress());
			doctor.setOfficeAddress(bean.getOfficeAddress());
			doctor.setCity(bean.getCity());
			// doctor.setZipCode(bean.getZipCode());
			doctor.setPhoneNumber(bean.getPhoneNumber());
			// doctor.setAboutDoctor(bean.getAboutDoctor());
			doctor.setDoctorImage(bean.getDoctorImage());
			// doctor.setTermsAndCondition(bean.getTermsAndCondition());
			// doctor.setPassword(bean.getPassword());
			transaction.commit();
			entityManager.close();
			return true;
		}
		return false;

	}

	@Override
	public List<Doctor> searchDoctor1(String doctorCity) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = " select d from Doctor d where d.city=:city";
		TypedQuery<Doctor> query = manager.createQuery(jpql, Doctor.class);
		query.setParameter("city", doctorCity);
		query.getResultList();
		List<Doctor> list = query.getResultList();
		return list;
	}

	@Override
	public Doctor serarchDoctor(int doctorId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = " select d from Doctor d where d.doctorId=:doctorId";
		Doctor doctor = manager.find(Doctor.class, doctorId);
		return doctor;
	}

}
