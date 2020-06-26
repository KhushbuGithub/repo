package com.capgemini.bookmydoctor.service;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Patient;

public interface PatientService {
	public boolean addPatient(Patient patient);

	public Patient serarchPatient(int patientId);

	public List<Patient> getAllPatients();

	public boolean deletePatient(int patientId);
	
	public boolean modifyPatient(Patient bean);

}
