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

@Repository
public class DoctorDAOImpl implements DoctorDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	
	public boolean addDoctor(Doctor bean) {

		EntityManager manager = entityManagerFactory.createEntityManager();
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
		String jpql = "from Doctor";
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
		if(doctor != null) {
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
			//doctor.setZipCode(bean.getZipCode());
			doctor.setPhoneNumber(bean.getPhoneNumber());
		//	doctor.setAboutDoctor(bean.getAboutDoctor());
			doctor.setDoctorImage(bean.getDoctorImage());
		//	doctor.setTermsAndCondition(bean.getTermsAndCondition());
		//	doctor.setPassword(bean.getPassword());
            transaction.commit();
            entityManager.close();
			return true;
	}
		return false;

}


//	@Override
//	public List<Doctor> searchDoctor(String city, String Specialization, String gender, String language1, String language2) {
//		List<Doctor> list = new ArrayList<Doctor>();
//		EntityManager manager = entityManagerFactory.createEntityManager();
//		String jpql = "from Doctor where ((city=:city OR specialization=:specialization OR language1=:language1 OR language2=:language2 OR gender=:gender) OR"
//				+ "(city=:city AND specialization=:specialization OR city=:city AND language1=:language1 OR city=:city AND language2=:language2 OR city=:city AND gender=:gender OR"
//				+ "specialization=:specialization AND language1=:language1 OR specialization=:specialization AND language2=:language2 OR specialization=:specialization AND gender=:gender OR"
//				+ "language1=:language1 AND gender=:gender OR language2=:language2 AND gender=:gender) OR"
//				+"(city=:city AND specialization=:specialization AND language1=:language1 OR city=:city AND specialization=:specialization AND language2=:language2 OR city=:city AND specialization=:specialization AND gender=:gender OR"
//				+ "specialization=:specialization AND language1=:language1 AND gender=:gender OR specialization=:specialization AND language2=:language2 AND gender=:gender)"
//				+"(city=:city AND specialization=:specialization AND language1=:language1 AND gender=:gender OR city=:city AND specialization=:specialization AND language2=:language2 AND gender=:gender ))";
//		TypedQuery<Doctor> query = manager.createQuery(jpql, Doctor.class);
//	    query.getResultList();
//	    list = query.getResultList();
//	    manager.close();
//	    return list;
//		
//	}

//	@Override
//	public List<Doctor> searchDoctor2(String city, String Specialization) {
//		List<Doctor> list = new ArrayList<Doctor>();
//		EntityManager manager = entityManagerFactory.createEntityManager();
//		String jpql = "from Doctor where city=:city AND Specialization=:Specialization OR city=:city AND language1=:language1 OR city=:city AND language2=:language2 OR city=:city AND gender=:gender OR"
//				+ "Specialization=:Specialization AND language1=:language1 OR Specialization=:Specialization AND language2=:language2 OR Specialization=:Specialization AND gender=:gender OR"
//				+ "language1=:language1 AND gender=:gender OR language2=:language2 AND gender=:gender";
//		TypedQuery<Doctor> query = manager.createQuery(jpql, Doctor.class);
//		query.setParameter("city", city);
//		query.setParameter("Specialization", city);
//		query.setParameter("language1", city);
//		query.setParameter("language2", city );
//		query.setParameter("gender", city);
//		query.setParameter("city", Specialization);
//		query.setParameter("Specialization", Specialization);
//		query.setParameter("language1", Specialization);
//		query.setParameter("language2", Specialization );
//		query.setParameter("gender", Specialization);
//		
//		
//	    query.getResultList();
//	    list = query.getResultList();
//	    manager.close();
//	    return list;
//	}

	@Override
	public List<Doctor> searchDoctor1(String city) {
		List<Doctor> list = new ArrayList<Doctor>();
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from Doctor where city=:city OR specialization=:specialization OR language1=:language1 OR language2=:language2 OR gender=:gender";
		TypedQuery<Doctor> query = manager.createQuery(jpql, Doctor.class);
		query.setParameter("city", city);
		query.setParameter("specialization", city);
		query.setParameter("language1", city);
		query.setParameter("language2", city);
		query.setParameter("gender", city);
	    query.getResultList();
	    list = query.getResultList();
	    manager.close();
	    return list;
	}

	@Override
	public Doctor serarchDoctor(int doctorId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		Doctor doctor = manager.find(Doctor.class, doctorId);
		return doctor;
	}

	
}
