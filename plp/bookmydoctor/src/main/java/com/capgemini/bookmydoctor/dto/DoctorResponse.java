package com.capgemini.bookmydoctor.dto;

import java.util.List;

import lombok.Data;

@Data
public class DoctorResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<Doctor> bean;

}
