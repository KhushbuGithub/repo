package com.capgemini.javacloud.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.javacloud.dto.Doctor;
import com.capgemini.javacloud.service.DoctorService;

@SpringBootTest
class DoctorServiceTest {

	@Autowired
	private DoctorService service;
	Doctor bean = null;
	boolean addDoctor = false;

	@BeforeEach
	void addDoctor() {
		bean = new Doctor();
		bean.setDoctorName("Khushbu");
		bean.setGender("Female");
		bean.setEmail("khushbu@gmail.com");
		bean.setAge(25);
		bean.setSpecialization("Dentist");
		bean.setLanguage1("English");
		bean.setLanguage2("Hindi");
		bean.setHomeAddress("BTM Layout");
		bean.setOfficeAddress("White-Field");
		bean.setCity("Bangalore");
		bean.setPhoneNumber(8874152963l);
		bean.setDoctorImage("dfghj");
		// bean.setPassword("Qwerty@123");
		addDoctor = service.addDoctor(bean,6);
	}

	@Test
	void testAddDoctor() {
		assertFalse(addDoctor);
	}

	@AfterEach
	void testDeleteDoctor() {
		service.deleteDoctor(bean.getUserId());
	}

	@Test
	void testGetAllDoctors() {
		List<Doctor> list = service.getAllDoctors();
		assertNotNull(list);
	}

	@Test
	void testSearchDoctor1() {
		List<Doctor> list = service.searchDoctor(bean.getCity());
		assertNotNull(list);
	}

	@Test
	void testGetDoctor() {
		Doctor list = service.serarchDoctor(bean.getUserId());
		assertNull(list);
	}

	@Test
	void testModifyDoctor() {
		bean.getUserId();

		assertFalse(service.modifyDoctor(bean));
		bean.setDoctorName("Sai");
		bean.setGender("Female");
		bean.setEmail("sai@gmail.com");
		bean.setAge(22);
		bean.setSpecialization("general");
		bean.setLanguage1("English");
		bean.setLanguage2("Hindi");
		bean.setHomeAddress("Mudhol-Navnagar");
		bean.setOfficeAddress("Bangalore-Jayanagar");
		bean.setCity("Mangalore");
		bean.setPhoneNumber(8874152963l);
		bean.setDoctorImage("dfghj");

	}


}
