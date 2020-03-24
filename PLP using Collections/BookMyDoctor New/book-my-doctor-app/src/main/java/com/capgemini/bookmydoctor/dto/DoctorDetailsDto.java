package com.capgemini.bookmydoctor.dto;

import lombok.Data;

@Data
public class DoctorDetailsDto {

	private int doctorId;
	private String doctorName;
	private String specialization;
	private String emailId;
	private String password;
	private String availability;
	private int charges;
	private String location;
	private long contact;
	private boolean leaveStatus;

}
