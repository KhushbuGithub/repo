package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Doctor;

@SpringBootTest
class DoctorDAOTest {
	
	@Autowired
	private DoctorDAO dao;
	Doctor bean = null;
	boolean addDoctor = false;

	@BeforeEach
	void addDoctor() {
		bean = new Doctor();
		bean.setDoctorName("Nusrat");
		bean.setGender("Female");
		bean.setEmail("nusrat@gmail.com");
		bean.setAge(25);
		bean.setSpecialization("general");
		bean.setLanguage1("English");
		bean.setLanguage2("Hindi");
		bean.setHomeAddress("Mudhol-Navnagar");
		bean.setOfficeAddress("Bangalore-Jayanagar");
		bean.setCity("Mangalore");
		bean.setPhoneNumber(8874152963l);
		bean.setDoctorImage("dfghj");
		bean.setPassword("Qwerty@123");
		addDoctor = dao.addDoctor(bean);
	}
	
	@Test
	void testAddDoctor() {
		assertTrue(addDoctor);
	}

	@AfterEach
	void testDeleteDoctor() {
		dao.deleteDoctor(bean.getDoctorId());
	}

	@Test
	void testGetAllDoctors() {
		List<Doctor> list = dao.getAllDoctors();
		assertNotNull(list);
	}

	@Test
	void testSearchDoctor1() {
		List<Doctor> list = dao.searchDoctor1(bean.getCity());
		assertNotNull(list);
	}

	@Test
	void testGetDoctor() {
		Doctor list = dao.serarchDoctor(bean.getDoctorId());
		assertNotNull(list);
	}

	@Test
	void testModifyDoctor() {
		bean.getDoctorId();
		assertTrue(dao.modifyDoctor(bean));
		bean.setDoctorName("Sangu");
		bean.setGender("Female");
		bean.setEmail("sangu@gmail.com");
		bean.setAge(22);
		bean.setSpecialization("general");
		bean.setLanguage1("English");
		bean.setLanguage2("Hindi");
		bean.setHomeAddress("Mudhol-Navnagar");
		bean.setOfficeAddress("Bangalore-Jayanagar");
		bean.setCity("Mangalore");
		bean.setPhoneNumber(8874152963l);
		bean.setDoctorImage("dfghj");
		bean.setPassword("Qwerty@123");
		
		
	}

}
