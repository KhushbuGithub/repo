package com.capgemini.javacloud.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.javacloud.dao.AppiontmentBookingDAO;
import com.capgemini.javacloud.dto.AppiontmentBooking;

@SpringBootTest
class AppiontmentBookingDAOTest {
	
	@Autowired
	private AppiontmentBookingDAO dao;
	AppiontmentBooking bean = null;
	boolean addAppiontment = false;

	@BeforeEach
	void addAppiontment() {
		bean = new AppiontmentBooking();
		bean.setPatientName("XYZ");
		bean.setAge(25.5);
		bean.setDiseaseSymptoms("cough");
		bean.setApproval("pending");
//		bean.setPatientId(4);
		bean.setTimeSlot("8am-12pm");
		bean.setAppointmentDate("12-11-2020");
		addAppiontment = dao.addAppiontment(bean);
	}
	
	@AfterEach
	void testDeleteAppiontment() {
		dao.deleteAppiontment(bean.getAppiontmentId());
	}
	
	@Test
	void testAddAppiontment() {
		assertFalse(addAppiontment);
	}

	@Test
	void testSerarchAppiontment() {
		AppiontmentBooking list = dao.searchAppiontment(bean.getAppiontmentId());
		assertNull(list);
		
	}

	@Test
	void testGetAllAppiontments() {
		List<AppiontmentBooking> list = dao.getAllAppiontments();
		assertNotNull(list);
	}

	

	@Test
	void testModifyAppiontment() {
		
		bean.getAppiontmentId();
		assertFalse(dao.modifyAppiontment(bean));
		bean.setPatientName("Ram");
		bean.setAge(25.5);
		bean.setDiseaseSymptoms("cough");
		bean.setApproval("pending");
//		bean.setPatientId(4);
		addAppiontment = dao.addAppiontment(bean);
	}

}
