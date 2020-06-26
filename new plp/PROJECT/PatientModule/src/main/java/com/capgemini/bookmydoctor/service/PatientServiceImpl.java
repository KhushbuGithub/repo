package com.capgemini.bookmydoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.PatientDAO;
import com.capgemini.bookmydoctor.dto.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDAO dao;

	@Override
	public boolean addPatient(Patient patient, int id) {
		return dao.addPatient(patient, id);

	}

	@Override
	public Patient serarchPatient(int patientId) {
		return dao.serarchPatient(patientId);
	}

	@Override
	public List<Patient> getAllPatients() {
		return dao.getAllPatients();
	}

	@Override
	public boolean deletePatient(int patientId) {
		return dao.deletePatient(patientId);
	}

	@Override
	public boolean modifyPatient(Patient bean) {
		return dao.modifyPatient(bean);

	}
}
