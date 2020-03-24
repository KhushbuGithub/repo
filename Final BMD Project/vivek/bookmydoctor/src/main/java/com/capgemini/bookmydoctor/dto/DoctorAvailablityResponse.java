package com.capgemini.bookmydoctor.dto;

import java.util.List;

import lombok.Data;

@Data
public class DoctorAvailablityResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<DoctorAvailablity> bean;

}
