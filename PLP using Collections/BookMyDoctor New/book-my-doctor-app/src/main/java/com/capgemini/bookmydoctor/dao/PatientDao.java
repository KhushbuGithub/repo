package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;

public interface PatientDao {
	
	public boolean registerPatient(PatientRegistrationDto patient);

    public  boolean deletePatient(int patientId);
    
    public boolean updatePatient(PatientRegistrationDto patient);
    
    public PatientRegistrationDto getPatient(int patientId);
    
    List<PatientRegistrationDto> getAllPatient();
    
	

}
