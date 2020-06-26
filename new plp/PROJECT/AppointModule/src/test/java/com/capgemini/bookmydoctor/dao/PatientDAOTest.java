package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Patient;

@SpringBootTest
class PatientDAOTest {
	
	@Autowired
	private PatientDAO dao;
	Patient bean = null;
	boolean addPatient = false;
	
	@BeforeEach
	void addPatient() {
		bean = new Patient();
		bean.setPatientName("Rajat");
		bean.setGender("Male");
		bean.setEmail("rajat@gmail.com");
		bean.setPassword("Qwerty@123");
		bean.setAge(25.5);
		bean.setMobileNumber(8874152639l);
		bean.setLocation("Bangalore");
		bean.setLanguage("English");
		bean.setTermsAndCondition("Agreed");
		addPatient = dao.addPatient(bean);
	}
	
	@AfterEach
	void testDeletePatient() {
		dao.deletePatient(bean.getUserId());
	}
		
	

	@Test
	void testAddPatient() {
		assertTrue(addPatient);
	}

	@Test
	void testSerarchPatient() {
		Patient list = dao.serarchPatient(bean.getUserId());
		assertNotNull(list);
	}

	@Test
	void testGetAllPatients() {
		List<Patient> list = dao.getAllPatients();
		assertNotNull(list);
	}

	@Test
	void testModifyPatient() {
		
		bean.getUserId();
		assertTrue(dao.modifyPatient(bean));
		bean.setPatientName("Peter");
		bean.setGender("Male");
		bean.setEmail("peter@gmail.com");
		bean.setPassword("Qwerty@123");
		bean.setAge(25.5);
		bean.setMobileNumber(8874152639l);
		bean.setLocation("Bangalore");
		bean.setLanguage("English");
		bean.setTermsAndCondition("Agreed");
		

		
	}

}
