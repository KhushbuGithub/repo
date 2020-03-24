package com.capgemini.bookmydoctor.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;

public class PatientDaoImpl implements PatientDao {

	private LinkedList<PatientRegistrationDto> patientDto = MyDoctorDB.patientregistrationDto;

	@Override
	public boolean registerPatient(PatientRegistrationDto patient) {
		for (PatientRegistrationDto patientInfoDto : patientDto) {
			if ((patientInfoDto.getPatientId() == patient.getPatientId())
					|| (patientInfoDto.getEmailId() == patient.getEmailId())) {
				return false;
			}
		}
		MyDoctorDB.patientregistrationDto.add(patient);
		return true;
	}

	@Override
	public boolean deletePatient(int patientId) {
		PatientRegistrationDto dto = null;
		for (PatientRegistrationDto patientInfoDto : patientDto) {
			if (patientInfoDto.getPatientId() == patientId) {
				dto = patientInfoDto;
				MyDoctorDB.patientregistrationDto.remove(dto);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updatePatient(PatientRegistrationDto patient) {
		for (PatientRegistrationDto patientInfoDto : patientDto) {
			if (patientInfoDto.getPatientId() == patient.getPatientId()) {
				patientInfoDto.setPatientName(patient.getPatientName());
				patientInfoDto.setEmailId(patient.getEmailId());
				patientInfoDto.setPassword(patient.getPassword());
				// patientInfoDto.setDateOfRegistration(patient.getDateOfRegistration());
				patientInfoDto.setGender(patient.getGender());
				// patientInfoDto.setDOB(patient.getDOB());
				patientInfoDto.setAge(patient.getAge());
				patientInfoDto.setPhoneNumber(patient.getPhoneNumber());
				// patientInfoDto.setProblem(patient.getProblem());
				patientInfoDto.setAddress(patient.getAddress());
				return true;
			}
		}
		return false;
	}

	@Override
	public PatientRegistrationDto getPatient(int patientId) {
		PatientRegistrationDto dto = null;
		for (PatientRegistrationDto patientInfoDto : patientDto) {
			if (patientInfoDto.getPatientId() == patientId) {
				dto = patientInfoDto;
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<PatientRegistrationDto> getAllPatient() {
		List<PatientRegistrationDto> doctorDtos = patientDto;
		return doctorDtos;
	}

}
