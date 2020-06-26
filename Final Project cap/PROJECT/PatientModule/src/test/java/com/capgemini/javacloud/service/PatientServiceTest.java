package com.capgemini.javacloud.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.javacloud.dto.Patient;
import com.capgemini.javacloud.service.PatientService;

@SpringBootTest
class PatientServiceTest {

	@Autowired
	private PatientService service;
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
		addPatient = service.addPatient(bean, 9);
	}

	@AfterEach
	void testDeletePatient() {
		service.deletePatient(bean.getUserId());
	}

	@Test
	void testAddPatient() {
		assertFalse(addPatient);
	}

	@Test
	void testSerarchPatient() {
		Patient list = service.serarchPatient(bean.getUserId());
		assertNull(list);
	}

	@Test
	void testGetAllPatients() {
		List<Patient> list = service.getAllPatients();
		assertNotNull(list);
	}

	@Test
	void testModifyPatient() {

		bean.getUserId();
		assertFalse(service.modifyPatient(bean));
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
