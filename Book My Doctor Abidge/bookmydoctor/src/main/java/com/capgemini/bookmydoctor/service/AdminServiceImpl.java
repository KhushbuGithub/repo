package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dao.AdminDaoImpl;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.factory.Factory;

public class AdminServiceImpl implements AdminService {

	AdminDaoImpl adminDao = (AdminDaoImpl) Factory.getAdminDao();

	@Override
	public boolean registerAdmin(AdminDto admin) {

		return adminDao.registerAdmin(admin);
	}

	@Override
	public boolean loginAdmin(int adminId, String password) {

		return adminDao.loginAdmin(adminId, password);
	}

	@Override
	public boolean addDoctor(DoctorDetailsDto doctor) {
		
		return adminDao.addDoctor(doctor);
	}
	
	
	@Override
	public boolean deleteDoctor(int doctorId) {
		
		return adminDao.deleteDoctor(doctorId);
	}
	
//	@Override
//	public boolean addPatient(PatientRegistrationDto patient) {
//		
//		return adminDao.addPatient(patient);
//	}

	@Override
	public boolean deletePatient(int patientId) {

		return adminDao.deletePatient(patientId);
	}

	@Override
	public List<AppointmentDto> viewAppointment(int appointmentId) {

		return adminDao.viewAppointment(appointmentId);
	}
	
	@Override
	public boolean updateAppointment(Date appointmentDate,Time appointmentTime,int appointmentId) {
		
		return adminDao.updateAppointment( appointmentDate, appointmentTime,appointmentId);
	}

	@Override
	public List<DoctorDetailsDto> viewDoctor(int doctorId) {

		return adminDao.viewDoctor(doctorId);
	}

	@Override
	public boolean deleteAdmin(int adminId) {

		return adminDao.deleteAdmin(adminId);
	}

}
