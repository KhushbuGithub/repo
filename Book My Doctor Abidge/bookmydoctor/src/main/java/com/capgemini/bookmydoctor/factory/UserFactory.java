package com.capgemini.bookmydoctor.factory;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dao.DoctorDaoImpl;
import com.capgemini.bookmydoctor.dao.UserDaoImpl;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.PaymentDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.service.UserService;
import com.capgemini.bookmydoctor.service.UserServiceImpl;

public class UserFactory {

	private UserFactory() {

	}

	public static HospitalDetailsDto getHospitalDetailsDto() {
		HospitalDetailsDto hospitalDetailsDto = new HospitalDetailsDto();
		return hospitalDetailsDto;
	}

	public static PatientRegisterDto getPatientRegistrationDto() {
		PatientRegisterDto patientRegistrationDto = new PatientRegisterDto();
		return patientRegistrationDto;
	}

	public static PaymentDto getPaymentDto() {
		PaymentDto paymentDto = new PaymentDto();
		return paymentDto;
	}

	public static UserDto getUserDto() {
		UserDto userDto = new UserDto();
		return userDto;
	}

//	public static AdminDto getAdminDto() {
//		AdminDto adminDto = new AdminDto();
//		return adminDto;
//	}

	public static DoctorDao getDoctorDao() {
		DoctorDao doctorDao = (DoctorDao) new DoctorDaoImpl();
		return doctorDao;
	}

	public static UserDaoImpl getUserDao() {
		UserDaoImpl userDao = new UserDaoImpl();
		return userDao;
	}
	
	public static UserService getUserService() {
		return new UserServiceImpl();
	}
}
