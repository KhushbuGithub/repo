package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.DoctorAvailablity;

@SpringBootTest
class DoctorAvailablityDAOTest {
	@Autowired
	private DoctorAvailablityDAO dao;
	DoctorAvailablity bean = null;
	boolean addDoctorAvailability = false;

	@BeforeEach
	void addDoctorAvailability() {
		bean = new DoctorAvailablity();
		bean.setDoctorId(120);
		bean.setFromDate("06-02-2020");
		bean.setToDate("20-02-2020");
		addDoctorAvailability = dao.addDoctorAvailability(bean);
	}
	
	@Test
	void testAddDoctorAvailability() {
		assertTrue(addDoctorAvailability);
	}


	@AfterEach
	void testDeleteDoctorAvailability() {
		dao.deleteDoctorAvailability(bean.getAvailabilityId());
	}

	@Test
	void testGetAllDoctorAvailabilities() {
		List<DoctorAvailablity> list = dao.getAllDoctorAvailabilities();
		assertNotNull(list);
	}

	@Test
	void testSearchDoctorAvailability() {
		DoctorAvailablity list = dao.searchDoctorAvailability(bean.getAvailabilityId());
		assertNotNull(list);
	}

	@Test
	void testModifyDoctorAvailability() {
		bean.getAvailabilityId();
		assertTrue(dao.modifyDoctorAvailability(bean));
		bean.setDoctorId(180);
		bean.setFromDate("08-02-2020");
		bean.setToDate("15-02-2020");
	}

}
