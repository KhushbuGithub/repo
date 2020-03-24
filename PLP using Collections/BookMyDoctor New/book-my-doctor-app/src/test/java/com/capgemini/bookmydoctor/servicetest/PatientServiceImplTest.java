package com.capgemini.bookmydoctor.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;
import com.capgemini.bookmydoctor.exceptions.ValidInputException;
import com.capgemini.bookmydoctor.service.PatientService;
import com.capgemini.bookmydoctor.service.PatientServiceImpl;

class PatientServiceImplTest {

	private PatientRegistrationDto dto = new PatientRegistrationDto();
	private PatientService dao = new PatientServiceImpl();

	@Test
	public void registerPatientTest() {
		try {
			dto.setPatientId(226);
			dto.setPatientName("XYZ");
			dto.setPhoneNumber(98765432);
			dto.setEmailId("xyz@gmail.com");
			dto.setPassword("Querty@1A");
			dto.setGender("F");
			dto.setAge(23);
			dto.setAddress("BTM");
			boolean expectedFlag = dao.registerPatient(dto);
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.registerPatient(dto);
			});
		}
	}

	@Test
	public void deletePatientTest() {
		try {
			dto.setPatientId(226);
			boolean expectedFlag = dao.deletePatient(dto.getPatientId());
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.deletePatient(dto.getPatientId());
			});
		}
	}

	@Test
	public void updatePatient() {
		try {
			dto.setPatientId(222);
			dto.setPatientName("ABC");
			dto.setPhoneNumber(987654432);
			dto.setEmailId("abc@gmail.com");
			dto.setAddress("Silk Board");
			dto.setAge(34);
			dto.setGender("M");
			dto.setPassword("querty@1A");
			boolean expectedFlag = dao.updatePatient(dto);
			assertEquals(expectedFlag, false);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.getPatient(dto.getPatientId());
			});
		}
	}

	@Test
	public void getAllPatient() {
		List<PatientRegistrationDto> all = dao.getAllPatient();
		assertNotNull(all);
	}

	@Test
	public void getPatientById() {
		dto.setPatientId(226);
		try {
			PatientRegistrationDto dto1 = dao.getPatient(dto.getPatientId());
			assertNotNull(dto1);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.getPatient(dto.getPatientId());
			});
		}
	}

}
