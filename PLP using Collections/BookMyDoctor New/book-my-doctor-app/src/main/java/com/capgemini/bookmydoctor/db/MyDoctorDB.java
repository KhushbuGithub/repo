package com.capgemini.bookmydoctor.db;

import java.util.LinkedList;

import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;
import com.capgemini.bookmydoctor.dto.RatingDto;

public class MyDoctorDB {

	public static final LinkedList<AppointmentDto> appointmentDto = new LinkedList<AppointmentDto>();

	public static final LinkedList<AdminDto> adminDto = new LinkedList<AdminDto>();

	public static final LinkedList<PatientRegistrationDto> patientregistrationDto = new LinkedList<PatientRegistrationDto>();

	public static final LinkedList<DoctorDetailsDto> doctordetailsDto = new LinkedList<DoctorDetailsDto>();

	public static final LinkedList<RatingDto> ratingDto = new LinkedList<RatingDto>();

	static {

		RatingDto rd1 = new RatingDto();
		rd1.setPatientId(1);
		rd1.setDoctorId(101);
		rd1.setDoctorName("Khusboo");
		rd1.setPatientName("Sai");
		rd1.setRating("good");
		ratingDto.add(rd1);

		AdminDto ad1 = new AdminDto();
		ad1.setAdminId(1);
		ad1.setAdminName("Rajat");
		ad1.setPassword("querty@1A");
		ad1.setAdminEmailId("rajat@gmail.com");
		adminDto.add(ad1);

		AppointmentDto amd1 = new AppointmentDto();
		amd1.setAppointmentId(111);
		amd1.setPatientId(1);
		amd1.setPatientName("Sai");
		amd1.setAppointmentDateandTime("20-10-2019 9:00 AM - 10:00 AM");
		amd1.setDoctorName("Khusboo");
		amd1.setDoctorId(101);
		appointmentDto.add(amd1);

		DoctorDetailsDto dd1 = new DoctorDetailsDto();
		dd1.setDoctorId(101);
		dd1.setDoctorName("Khusboo");
		dd1.setCharges(1000);
		dd1.setSpecialization("Nuerologist");
		dd1.setAvailability("9:00 AM - 9:00 PM");
		dd1.setEmailId("khusboo@gmail.com");
		dd1.setPassword("querty@1A");
		dd1.setLocation("Bhopal");
		dd1.setContact(8109688225l);
		dd1.setLeaveStatus(false);
		doctordetailsDto.add(dd1);

		PatientRegistrationDto prd1 = new PatientRegistrationDto();
		prd1.setPatientName("Sai");
		prd1.setGender("Male");
		prd1.setAge(23);
		prd1.setAddress("Mynta tech park");
		prd1.setEmailId("sai@gmail.com");
		prd1.setPassword("querty@1A");
		prd1.setPatientId(1);
		prd1.setPhoneNumber(98745612l);
		patientregistrationDto.add(prd1);

	}

}
