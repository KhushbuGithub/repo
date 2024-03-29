package com.capgemini.bookmydoctor.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.PaymentDto;
import com.capgemini.bookmydoctor.dto.UserDto;

public interface DoctorDao {

	public boolean doctorDescription(DoctorDetailsDto dto);

	public List<HospitalDetailsDto> viewFeedback(String hospitalName);

	public List<PatientRegisterDto> searchPatientHistory(int patientId);

	public List<AppointmentDto> viewAppointment(int doctorId);

	public List<PaymentDto> viewPaymentDetails(int patientId);

	public boolean manageAvailability(int doctorId, String availabilityFromDay, String availabilityEndDay,
			Time availabilityStartTime, Time availabilityEndTime, int charges);

}
