package com.capgemini.bookmydoctor.daotest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dao.DoctorDaoImpl;
import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.exceptions.ValidInputException;

class DoctorDaoImplTest {

	private DoctorDetailsDto dto = new DoctorDetailsDto();
	private DoctorDao dao = new DoctorDaoImpl();

	@Test
	public void registerDoctorTest() {
		try {
			dto.setDoctorId(109);
			dto.setDoctorName("ABC");
			dto.setEmailId("abc@gmail.com");
			dto.setPassword("querty@1A");
			dto.setAvailability("9:30-17:30");
			dto.setCharges(500);
			dto.setContact(987654321);
			dto.setLeaveStatus(false);
			dto.setLocation("Pune");
			dto.setSpecialization("Dentist");
			// dto.setYearOfExperience(7);
			boolean expectedFlag = dao.registerDoctor(dto);
			assertEquals(expectedFlag, true);
			MyDoctorDB.doctordetailsDto.add(dto);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.registerDoctor(dto);
			});
		}
	}

	@Test
	public void updateDoctorTest() {
		try {
			dto.setDoctorName("XYZ");
			dto.setEmailId("xyz@gmail.com");
			dto.setDoctorId(101);
			dto.setCharges(900);
			dto.setAvailability("10:30-19:30");
			dto.setContact(987654321);
			dto.setLeaveStatus(true);
			dto.setPassword("querty@1A");
			dto.setSpecialization("Neurologist");
			// dto.setYearOfExperience(9);
			dto.setLocation("Hyderabad");
			boolean expectedFlag = dao.updateDoctor(dto);
			assertEquals(expectedFlag, false);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.getDoctor(dto.getDoctorId());
			});
		}
	}

	@Test
	public void deleteDoctorTest() {
		try {
			dto.setDoctorId(101);
			boolean expectedFlag = dao.deleteDoctor(dto.getDoctorId());
			assertTrue(expectedFlag);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.deleteDoctor(dto.getDoctorId());
			});
		}
	}

	@Test
	public void getAllDoctorTest() {
		List<DoctorDetailsDto> all = dao.getAllDoctor();
		assertNotNull(all);
	}

	@Test
	public void searchDoctorTest() {
		try {
			dto.setLocation("Hyderabad");
			dto.setAvailability("14:35-20:40");
			dto.setCharges(900);
			dto.setContact(98765432);
			dto.setDoctorName("Mickel");
			dto.setEmailId("mickel@gmail.com");
			dto.setLeaveStatus(false);
			dto.setPassword("querty");
			// dto.setYearOfExperience(9);
			dto.setSpecialization("ENT");
			MyDoctorDB.doctordetailsDto.add(dto);

			List<DoctorDetailsDto> expectedFlag = dao.searchDoctor("Pune");
			assertNotNull(expectedFlag);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.searchDoctor(dto.getLocation());
			});
		}
	}

	@Test
	public void getDoctorByIdTest() {
		try {
			dto.setDoctorId(109);
			DoctorDetailsDto dto1 = dao.getDoctor(dto.getDoctorId());
			assertNotNull(dto1);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.getDoctor(dto.getDoctorId());
			});

		}

	}

}
