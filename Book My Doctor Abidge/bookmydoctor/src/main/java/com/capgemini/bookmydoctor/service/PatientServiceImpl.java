package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.factory.Factory;

public class PatientServiceImpl implements PatientService {
	
	PatientDao pdao = Factory.getPatientDao();

	@Override
	public boolean patientDiscription(PatientRegisterDto dto) {

		return pdao.patientDiscription(dto);

	}

//	@Override
//	public boolean loginPatient(int patientId, String password, String userType) {
//
//		return pdao.loginPatient(patientId, password, userType);
//	}

	@Override
	public List<HospitalDetailsDto> chooseHospital(int rating, int hospitalId) {
		
		return pdao.chooseHospital(rating, hospitalId);

	}

	@Override
	public List<DoctorDetailsDto> searchDoctor(String specialization) {

		return pdao.searchDoctor(specialization);

	}

	@Override
	public List<DoctorDetailsDto> selectDoctor(int doctorId, String doctorName, String specialization) {

		return pdao.selectDoctor(doctorId, doctorName, specialization);
	}

	@Override
	public boolean makePayment(int patientId, String paymentType, Date paymentDate, int amount) {

		return pdao.makePayment(patientId, paymentType, paymentDate, amount);
	}

	@Override
	public boolean manageAppointment(int patientId) {

		return pdao.manageAppointment(patientId);
	}


}
