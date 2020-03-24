package com.capgemini.bookmydoctor.service;

import java.util.List;

import com.capgemini.bookmydoctor.dao.AppointmentDao;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.factory.DaoFactory;

public class AppointmentServiceImpl implements AppointmentService{
	
	private AppointmentDao dao= DaoFactory.getAppointmentDao();

	@Override
	public boolean registerAppointment(AppointmentDto appointment) {
		return dao.registerAppointment(appointment);
	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		return dao.deleteAppointment(appointmentId);
	}

	@Override
	public boolean updateAppointment(AppointmentDto appointment) {
		return dao.updateAppointment(appointment);
	}

	@Override
	public AppointmentDto getAppointment(int appointmentId) {
		return dao.getAppointment(appointmentId);
	}

	@Override
	public List<AppointmentDto> getAllAppointment() {
		return dao.getAllAppointment();
	}

	@Override
	public List<AppointmentDto> getAppointmentById(Integer id) {
		return dao.getAppointmentById(id);
	}

	

}
