package com.capgemini.javacloud.dao;

import java.util.List;

import com.capgemini.javacloud.dto.AppiontmentBooking;

public interface AppiontmentBookingDAO {
	public boolean addAppiontment(AppiontmentBooking appiontment);

	public AppiontmentBooking searchAppiontment(int appiontmentId);

	public List<AppiontmentBooking> getAllAppiontments();
	
	public List<AppiontmentBooking> getAppiontments(int patientId);
	
	public List<AppiontmentBooking> getAppiontmentsByName(String doctorName);

	public boolean deleteAppiontment(int appiontmentId);
	
	public boolean modifyAppiontment(AppiontmentBooking bean);

}
