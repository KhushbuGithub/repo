package com.capgemini.bookmydoctor.factory;

import com.capgemini.bookmydoctor.dao.AdminDao;
import com.capgemini.bookmydoctor.dao.AdminDaoImpl;
import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dao.DoctorDaoImpl;
import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dao.PatientDaoImpl;
import com.capgemini.bookmydoctor.dao.UserDao;
import com.capgemini.bookmydoctor.dao.UserDaoImpl;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AdminRegistrationDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.PaymentDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.service.AdminService;
import com.capgemini.bookmydoctor.service.AdminServiceImpl;
import com.capgemini.bookmydoctor.service.DoctorService;
import com.capgemini.bookmydoctor.service.DoctorServiceImpl;
import com.capgemini.bookmydoctor.service.PatientService;
import com.capgemini.bookmydoctor.service.PatientServiceImpl;
import com.capgemini.bookmydoctor.service.UserService;
import com.capgemini.bookmydoctor.service.UserServiceImpl;

public class Factory {

	private Factory() {

	}

	public static PatientDao getPatientDao() {
		PatientDao dao = new PatientDaoImpl();
		return dao;
	}

	public static PatientService getPatientServ() {
		PatientService dto1 = new PatientServiceImpl();
		return dto1;
	}

	public static PatientRegisterDto getPatientRegisterDto() {
		PatientRegisterDto dto = new PatientRegisterDto();
		return dto;
	}

	public static AdminDto getAdminDto() {
		AdminDto dto = new AdminDto();
		return dto;
	}

	public static AdminRegistrationDto getAdminRegistration() {
		AdminRegistrationDto dto = new AdminRegistrationDto();
		return dto;
	}

	public static AdminDao getAdminDao() {
		AdminDao dao = new AdminDaoImpl();
		return dao;
	}

	public static AdminService getAdminService() {
		return new AdminServiceImpl();
	}

	public static DoctorDetailsDto getDoctorDetailsDto() {
		DoctorDetailsDto doctorDetailsDto = new DoctorDetailsDto();
		return doctorDetailsDto;
	}

	public static AppointmentDto getAppointmetDto() {
		AppointmentDto appointDto = new AppointmentDto();
		return appointDto;
	}

	public static DoctorDao getDoctorDao() {
		DoctorDao doctorDao = (DoctorDao) new DoctorDaoImpl();
		return doctorDao;

	}

	public static DoctorService getDoctorService() {
		DoctorService doctorService = new DoctorServiceImpl();
		return doctorService;
	}

	public static UserDao getUserDao() {
		UserDao dao = new UserDaoImpl();
		return dao;
	}

	public static UserService getUserServ() {
		UserService serv = new UserServiceImpl();
		return serv;

	}

	public static UserDto getUserDto() {
		UserDto dto = new UserDto();
		return dto;
	}

	public static HospitalDetailsDto getHospDto() {
		return new HospitalDetailsDto();

	}

	public static PaymentDto getPaymentDto() {
		return new PaymentDto();

	}

}
