package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.DoctorAvailablity;

public interface DoctorAvailablityDAO {
	public boolean addDoctorAvailability(DoctorAvailablity bean);

	public boolean deleteDoctorAvailability(int availabilityId);

	public List<DoctorAvailablity> getAllDoctorAvailabilities();

	public DoctorAvailablity searchDoctorAvailability(int availabilityId);

	public boolean modifyDoctorAvailability(DoctorAvailablity bean);

}
