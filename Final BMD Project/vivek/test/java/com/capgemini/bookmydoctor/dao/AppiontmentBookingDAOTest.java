package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.AppointmentBooking;

@SpringBootTest
class AppiontmentBookingDAOTest {
	
	@Autowired
	private AppointmentBookingDAO dao;
	AppointmentBooking bean = null;
	boolean addAppiontment = false;

	@BeforeEach
	void addAppiontment() {
		bean = new AppointmentBooking();
		bean.setPatientName("Megha");
		bean.setAge(25.5);
		bean.setDiseaseSymptoms("cough");
		bean.setApproval("pending");
		bean.setPatientId(4);
		addAppiontment = dao.addAppointment(bean);
	}
	
	@AfterEach
	void testDeleteAppiontment() {
		dao.deleteAppointment(bean.getAppointmentId());
	}
	
	@Test
	void testAddAppiontment() {
		assertTrue(addAppiontment);
	}

	@Test
	void testSerarchAppiontment() {
		AppointmentBooking list = dao.serarchAppointment(bean.getAppointmentId());
		assertNotNull(list);
		
	}

	@Test
	void testGetAllAppiontments() {
		List<AppointmentBooking> list = dao.getAllAppointments();
		assertNotNull(list);
	}

	

	@Test
	void testModifyAppiontment() {
		
		bean.getAppointmentId();
		assertTrue(dao.modifyAppointment(bean));
		bean.setPatientName("Pooja");
		bean.setAge(25.5);
		bean.setDiseaseSymptoms("cough");
		bean.setApproval("pending");
		bean.setPatientId(4);
		addAppiontment = dao.addAppointment(bean);
	}

}
