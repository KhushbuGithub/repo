package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.UserDto;

public interface AdminService {

	public boolean registerAdmin(AdminDto admin);
	
	public boolean loginAdmin(int adminId, String password);
	
	public boolean addDoctor(DoctorDetailsDto doctor);
	
	public boolean deleteDoctor(int doctorId);
	
	//public boolean addPatient(PatientRegistrationDto patient);
	
	public boolean deletePatient(int patientId);
	
	public List<AppointmentDto> viewAppointment(int appointmentId);
	
	public boolean updateAppointment(Date appointmentDate,Time appointmentTime,int appointmentId);
	
	public List<DoctorDetailsDto> viewDoctor(int doctorId);
	
	public boolean deleteAdmin(int adminId);
	
}
