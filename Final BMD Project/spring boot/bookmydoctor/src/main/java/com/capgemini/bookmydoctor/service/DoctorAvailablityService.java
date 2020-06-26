package com.capgemini.bookmydoctor.service;

import java.util.List;

import com.capgemini.bookmydoctor.dto.DoctorAvailablity;

public interface DoctorAvailablityService {
	public boolean addDoctorAvailability(DoctorAvailablity bean);

	public boolean deleteDoctorAvailability(int availabilityId);

	public List<DoctorAvailablity> getAllDoctorAvailabilities();

	public DoctorAvailablity searchDoctorAvailability(int availabilityId);

	public boolean modifyDoctorAvailability(DoctorAvailablity bean);

}
