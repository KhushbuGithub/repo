package com.capgemini.bookmydoctor.dto;

import java.util.List;

import lombok.Data;

@Data
public class AppiontmentBookingResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<AppiontmentBooking> appiontmentBooking;

}
