package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.AppiontmentBooking;

@SpringBootTest
class AppiontmentBookingDAOTest {
	
	@Autowired
	private AppiontmentBookingDAO dao;
	AppiontmentBooking bean = null;
	boolean addAppiontment = false;

	@BeforeEach
	void addAppiontment() {
		bean = new AppiontmentBooking();
		bean.setPatientName("Megha");
		bean.setAge(25.5);
		bean.setDiseaseSymptoms("cough");
		bean.setApproval("pending");
		bean.setPatientId(4);
		addAppiontment = dao.addAppiontment(bean);
	}
	
	@AfterEach
	void testDeleteAppiontment() {
		dao.deleteAppiontment(bean.getAppiontmentId());
	}
	
	@Test
	void testAddAppiontment() {
		assertTrue(addAppiontment);
	}

	@Test
	void testSerarchAppiontment() {
		AppiontmentBooking list = dao.serarchAppiontment(bean.getAppiontmentId());
		assertNotNull(list);
		
	}

	@Test
	void testGetAllAppiontments() {
		List<AppiontmentBooking> list = dao.getAllAppiontments();
		assertNotNull(list);
	}

	

	@Test
	void testModifyAppiontment() {
		
		bean.getAppiontmentId();
		assertTrue(dao.modifyAppiontment(bean));
		bean.setPatientName("Pooja");
		bean.setAge(25.5);
		bean.setDiseaseSymptoms("cough");
		bean.setApproval("pending");
		bean.setPatientId(4);
		addAppiontment = dao.addAppiontment(bean);
	}

}
