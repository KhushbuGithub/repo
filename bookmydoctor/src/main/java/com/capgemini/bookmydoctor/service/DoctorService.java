package com.capgemini.bookmydoctor.service;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Doctor;

public interface DoctorService {
	public boolean addDoctor(Doctor bean);

	public boolean deleteDoctor(int doctorId);

	public List<Doctor> getAllDoctors();

//	public List<Doctor> searchDoctor(String city,String Specialization,String gender,String language1,String language2);
	
    public List<Doctor> searchDoctor1(String city);
	
//	public List<Doctor> searchDoctor2(String city,String Specialization);
//	
//	public List<Doctor> searchDoctor3(String city,String Specialization,String gender);
//	
//	public List<Doctor> searchDoctor4(String city,String Specialization,String gender,String language1);

	public boolean modifyDoctor(Doctor bean);
	
	public Doctor serarchDoctor(int doctorId);

}
