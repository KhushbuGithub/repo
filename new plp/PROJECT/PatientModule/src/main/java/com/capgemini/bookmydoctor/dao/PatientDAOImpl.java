package com.capgemini.bookmydoctor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.dto.User;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addPatient(Patient patient, int id) {
		EntityManager manager = factory.createEntityManager();
		User user = manager.find(User.class, id);
		patient.setUser(user);
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(patient);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Patient serarchPatient(int patientId) {
		EntityManager manager = factory.createEntityManager();
		Patient patient = manager.find(Patient.class, patientId);
		return patient;
	}

	@Override
	public List<Patient> getAllPatients() {
		String jpql = "select g from Patient g";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Patient> query = manager.createQuery(jpql, Patient.class);
		return query.getResultList();
	}




	@Override
	public boolean deletePatient(int patientId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Patient patient = manager.find(Patient.class, patientId);
		if (patient != null) {
			transaction.begin();
			manager.remove(patient);
			transaction.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyPatient(Patient bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Patient patient = manager.find(Patient.class, bean.getUserId());
		if (patient != null) {
			patient.setUserId(bean.getUserId());
			patient.setPatientName(bean.getPatientName());
			patient.setGender(bean.getGender());
			patient.setEmail(bean.getEmail());
			patient.setPassword(bean.getPassword());
			patient.setAge(bean.getAge());
			patient.setMobileNumber(bean.getMobileNumber());
			patient.setLocation(bean.getLocation());
			patient.setLanguage(bean.getLanguage());
			patient.setTermsAndCondition(bean.getTermsAndCondition());
			transaction.commit();
			manager.close();
			return true;
		}
		return false;
	}

}
