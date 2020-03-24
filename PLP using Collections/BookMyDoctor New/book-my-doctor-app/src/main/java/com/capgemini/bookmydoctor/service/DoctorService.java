package com.capgemini.bookmydoctor.service;

import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;

public interface DoctorService {
	
	public boolean registerDoctor(DoctorDetailsDto doctor);

    public  boolean deleteDoctor(int doctorId);
    
    public boolean updateDoctor(DoctorDetailsDto doctor);
    
    public DoctorDetailsDto getDoctor(int doctorId);
    
    List<DoctorDetailsDto> getAllDoctor(); 
    
    List<DoctorDetailsDto> searchDoctor(String location); 
    
    


}
