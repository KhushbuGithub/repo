package com.capgemini.bookmydoctor.service;

import java.util.List;

import com.capgemini.bookmydoctor.dto.AppiontmentBooking;

public interface AppiontmentBookingService {
	
	public boolean addAppiontment(AppiontmentBooking appiontment);

	public AppiontmentBooking serarchAppiontment(int appiontmentId);

	public List<AppiontmentBooking> getAllAppiontments();

	public boolean deleteAppiontment(int appiontmentId);
	
	public boolean modifyAppiontment(AppiontmentBooking bean);
	
	public List<AppiontmentBooking> getAppiontments(int patientId);
	
	public List<AppiontmentBooking> getAppiontmentsByName(String doctorName);

}
