package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Doctor;

public interface DoctorDAO {

	public boolean addDoctor(Doctor bean, int id);

	public boolean deleteDoctor(int doctorId);

	public List<Doctor> getAllDoctors();

	public List<Doctor> searchDoctor1(String doctorCity);

	public boolean modifyDoctor(Doctor bean);

	public Doctor serarchDoctor(int doctorId);

}
