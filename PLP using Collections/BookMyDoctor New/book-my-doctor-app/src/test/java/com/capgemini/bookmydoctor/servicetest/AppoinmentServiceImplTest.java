package com.capgemini.bookmydoctor.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.exceptions.ValidInputException;
import com.capgemini.bookmydoctor.service.AppointmentService;
import com.capgemini.bookmydoctor.service.AppointmentServiceImpl;

class AppoinmentServiceImplTest {
	private AppointmentDto dto = new AppointmentDto();
	private AppointmentService dao = new AppointmentServiceImpl();

	@Test
	public void registerAppoinmentTest() {
		try {
			dto.setAppointmentId(181);
			dto.setAppointmentDateandTime("20-11-2019");
			// dto.setAppointmentTime("6:30-AM");
			dto.setDoctorId(201);
			dto.setDoctorName("abcd");
			dto.setPatientId(111);
			dto.setPatientName("wert");
			boolean expectedFlag = dao.registerAppointment(dto);
			assertEquals(expectedFlag, true);
			MyDoctorDB.appointmentDto.add(dto);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.registerAppointment(dto);
			});
		}
	}

	@Test
	public void deleteAppoinmentTest() {
		try {
			dto.setAppointmentId(181);
			boolean expectedFlag = dao.deleteAppointment(dto.getAppointmentId());
			assertTrue(expectedFlag);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.deleteAppointment(dto.getAppointmentId());
			});
		}
	}

	@Test
	public void updateAppoinmentTest() {
		try {
			dto = new AppointmentDto();
			dto.setAppointmentDateandTime("20-11-2019");
			// dto.setAppointmentTime("4:30");
			dto.setDoctorId(101);
			dto.setDoctorName("XYZ");
			dto.setPatientId(90);
			dto.setPatientName("ASD");
			boolean expectedFlag = dao.updateAppointment(dto);
			assertEquals(expectedFlag, false);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.getAppointmentById(dto.getAppointmentId());
			});
		}
	}

	@Test
	public void getAllAppoinmentTest() {
		List<AppointmentDto> all = dao.getAllAppointment();
		assertNotNull(all);
	}

//	@Test
//	public void getAppoinmentById() {
//		dto.setAppointmentId(181);
//		try {
//			AppointmentDto dto1 = dao.getAppointment(dto.getAppointmentId());
//			assertNotNull(dto1);
//		} catch (Exception e) {
//			assertThrows(ValidInputException.class, () -> {
//				dao.getAppointment(dto.getAppointmentId());
//			});
//		}
//	}

}
