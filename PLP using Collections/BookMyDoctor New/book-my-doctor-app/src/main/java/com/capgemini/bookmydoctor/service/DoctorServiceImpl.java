package com.capgemini.bookmydoctor.service;

import java.sql.Time;
import java.util.List;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;
import com.capgemini.bookmydoctor.factory.DaoFactory;

public class DoctorServiceImpl implements DoctorService{
	
	private DoctorDao dao= DaoFactory.getDoctorDao();

	@Override
	public boolean registerDoctor(DoctorDetailsDto doctor) {
		return dao.registerDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		return dao.deleteDoctor(doctorId);
	}

	@Override
	public boolean updateDoctor(DoctorDetailsDto doctor) {
		return dao.updateDoctor(doctor);
	}

	@Override
	public DoctorDetailsDto getDoctor(int doctorId) {
		return dao.getDoctor(doctorId);
	}

	@Override
	public List<DoctorDetailsDto> getAllDoctor() {
		return dao.getAllDoctor();
	}

	@Override
	public List<DoctorDetailsDto> searchDoctor(String location) {
		return dao.searchDoctor(location);
	}
	
	

}
