package com.capgemini.javacloud.service;

import java.util.List;

import com.capgemini.javacloud.dto.Patient;

public interface PatientService {
	public boolean addPatient(Patient patient,int id);

	public Patient serarchPatient(int patientId);

	public List<Patient> getAllPatients();

	public boolean deletePatient(int patientId);
	
	public boolean modifyPatient(Patient bean);

}
