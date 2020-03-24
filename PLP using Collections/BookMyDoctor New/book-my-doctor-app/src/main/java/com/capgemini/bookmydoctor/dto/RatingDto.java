package com.capgemini.bookmydoctor.dto;

import lombok.Data;

@Data
public class RatingDto {
	private int patientId;
	private int doctorId;
	private String doctorName;
	private String patientName;
	private String rating;

}
