package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Patient;

public interface PatientDAO {
	public boolean addPatient(Patient patient);

	public Patient serarchPatient(int patientId);

	public List<Patient> getAllPatients();

	public boolean deletePatient(int patientId);
	
	public boolean modifyPatient(Patient bean);

}
