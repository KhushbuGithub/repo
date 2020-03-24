package com.capgemini.bookmydoctor.dto;

import lombok.Data;

@Data
public class PatientRegistrationDto {
	private int patientId;
	private String PatientName;
	private long phoneNumber;
	private String emailId;
	private String password;
	private int age;
	private String gender;
	private String address;

}
