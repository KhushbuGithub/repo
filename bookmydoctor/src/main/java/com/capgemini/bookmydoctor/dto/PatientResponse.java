package com.capgemini.bookmydoctor.dto;

import java.util.List;

import lombok.Data;

@Data
public class PatientResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<Patient> patient;

}
