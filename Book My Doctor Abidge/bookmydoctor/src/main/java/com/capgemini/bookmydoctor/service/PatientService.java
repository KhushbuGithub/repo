package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;

public interface PatientService {
	
	public boolean patientDiscription(PatientRegisterDto dto);

//	public boolean loginPatient(int patientId, String password, String userType);

	public List<HospitalDetailsDto> chooseHospital(int rating, int hospitalId);

	public List<DoctorDetailsDto> searchDoctor(String specialization);

	public List<DoctorDetailsDto> selectDoctor(int doctorId, String doctorName, String specialization);

	public boolean makePayment(int patientId, String paymentType, Date paymentDate, int amount);

	public boolean manageAppointment(int patientId);
}
