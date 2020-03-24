package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;

public interface DoctorDao {

	public boolean registerDoctor(DoctorDetailsDto doctor);

    public  boolean deleteDoctor(int doctorId);
    
    public boolean updateDoctor(DoctorDetailsDto doctor);
    
    public DoctorDetailsDto getDoctor(int doctorId);
    
    List<DoctorDetailsDto> getAllDoctor(); 
    
    List<DoctorDetailsDto> searchDoctor(String location); 

}
