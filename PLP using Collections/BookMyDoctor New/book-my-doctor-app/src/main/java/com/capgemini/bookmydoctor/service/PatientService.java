package com.capgemini.bookmydoctor.service;

import java.sql.Date;
import java.util.List;

import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;

public interface PatientService {

	public boolean registerPatient(PatientRegistrationDto patient);

    public  boolean deletePatient(int patientId);
    
    public boolean updatePatient(PatientRegistrationDto patient);
    
    public PatientRegistrationDto getPatient(int patientId);
    
    List<PatientRegistrationDto> getAllPatient();


}
