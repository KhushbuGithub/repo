package com.capgemini.javacloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.javacloud.dao.DoctorDAO;
import com.capgemini.javacloud.dto.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorDAO dao;

	@Override
	public boolean addDoctor(Doctor bean, int id) {
		return dao.addDoctor(bean, id);
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		return dao.deleteDoctor(doctorId);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return dao.getAllDoctors();
	}

	@Override
	public boolean modifyDoctor(Doctor bean) {
		return dao.modifyDoctor(bean);
	}

	@Override
	public List<Doctor> searchDoctor(String city) {
		return dao.searchDoctor(city);
	}

	@Override
	public Doctor serarchDoctor(int doctorId) {
		return dao.serarchDoctor(doctorId);
	}

}
