package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.PaymentDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.factory.Factory;
import com.capgemini.bookmydoctor.factory.UserFactory;

public class DoctorServiceImpl implements DoctorService {
	
	DoctorDao pdao = Factory.getDoctorDao();

//	public boolean loginDoctor(int password, String userType, String userName) {
//		
//		return pdao.loginDoctor(password, userType, userName);
//	}

	public List<HospitalDetailsDto> viewFeedback(String hospitalName) {
		
		return pdao.viewFeedback(hospitalName);
	}

	public List<PatientRegisterDto> searchPatientHistory(int patientId) {
		
		return pdao.searchPatientHistory(patientId);
	}

	public List<AppointmentDto> viewAppointment(int doctorId) {
		
		return pdao.viewAppointment(doctorId);
	}

	public List<PaymentDto> viewPaymentDetails(int patientId) {
		
		return pdao.viewPaymentDetails(patientId);
	}

	public boolean manageAvailability(int doctorId, String availabilityFromDay, String availabilityEndDay, Time availabilityStartTime, Time availabilityEndTime, int charges) {
		
		return pdao.manageAvailability(doctorId, availabilityFromDay, availabilityEndDay, availabilityStartTime, availabilityEndTime, charges);
	}

	@Override
	public boolean doctorDescription(DoctorDetailsDto dto) {
		return pdao.doctorDescription(dto);
	}

	

}
