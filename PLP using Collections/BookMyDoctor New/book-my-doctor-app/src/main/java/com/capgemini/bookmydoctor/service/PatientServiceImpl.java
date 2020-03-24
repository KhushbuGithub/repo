package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;
import com.capgemini.bookmydoctor.factory.DaoFactory;

public class PatientServiceImpl implements PatientService {

	private PatientDao dao = new DaoFactory().getPatientDao();

	@Override
	public boolean registerPatient(PatientRegistrationDto patient) {
		return dao.registerPatient(patient);
	}

	@Override
	public boolean deletePatient(int patientId) {
		return dao.deletePatient(patientId);
	}

	@Override
	public boolean updatePatient(PatientRegistrationDto patient) {
		return dao.updatePatient(patient);
	}

	@Override
	public PatientRegistrationDto getPatient(int patientId) {
		return dao.getPatient(patientId);
	}

	@Override
	public List<PatientRegistrationDto> getAllPatient() {
		return dao.getAllPatient();
	}

}
