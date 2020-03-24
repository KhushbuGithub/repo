package com.capgemini.bookmydoctor.dto;

import lombok.Data;

@Data
public class AppointmentDto {
	private int appointmentId;
	private int doctorId;
	private int patientId;
	private String patientName;
	private String doctorName;
	private String appointmentDateandTime;
}