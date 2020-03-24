package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.factory.DaoFactory;

public class AppointmentDaoImpl implements AppointmentDao {

	private LinkedList<AppointmentDto> appointmentDto = MyDoctorDB.appointmentDto;

	@Override
	public boolean registerAppointment(AppointmentDto appointment) {
		for (AppointmentDto appointmentInfoDto : appointmentDto) {
			if (appointmentInfoDto.getAppointmentId() == appointment.getAppointmentId()) {
				return false;
			}
		}
		MyDoctorDB.appointmentDto.add(appointment);
		return true;
	}

	@Override
	public boolean deleteAppointment(int appointmentId) {
		AppointmentDto dto = null;
		for (AppointmentDto appointmentInfoDto : appointmentDto) {
			if (appointmentInfoDto.getAppointmentId() == appointmentId) {
				dto = appointmentInfoDto;
				MyDoctorDB.appointmentDto.remove(dto);
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean updateAppointment(AppointmentDto appointment) {
		for (AppointmentDto appointmentInfoDto : appointmentDto) {
			if (appointmentInfoDto.getAppointmentId() == appointment.getAppointmentId()) {
				appointmentInfoDto.setDoctorId(appointment.getDoctorId());
				appointmentInfoDto.setDoctorName(appointment.getDoctorName());
				appointmentInfoDto.setAppointmentDateandTime(appointment.getAppointmentDateandTime());
				appointmentInfoDto.setPatientId(appointment.getPatientId());
				appointmentInfoDto.setPatientName(appointment.getPatientName());
				return true;
			}
		}
		return false;
	}

	@Override
	public AppointmentDto getAppointment(int appointmentId) {
		AppointmentDto dto = null;
		for (AppointmentDto appointmentInfoDto : appointmentDto) {
			if (appointmentInfoDto.getAppointmentId() == appointmentId) {
				dto = appointmentInfoDto;
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<AppointmentDto> getAllAppointment() {
		List<AppointmentDto> appointmentDtos = appointmentDto;
		return appointmentDtos;
	}

	@Override
	public List<AppointmentDto> getAppointmentById(Integer id) {
		AppointmentDao dao = DaoFactory.getAppointmentDao();
		List<AppointmentDto> appDto = new ArrayList<AppointmentDto>();
		for (AppointmentDto appInfo : appointmentDto) {
			if (id.equals(appInfo.getDoctorId())) {
				int appId = appInfo.getAppointmentId();
				appDto.add(dao.getAppointment(appId));
				return appDto;
			} else if (id.equals(appInfo.getPatientId())) {
				int appId2 = appInfo.getAppointmentId();
				appDto.add(dao.getAppointment(appId2));
				return appDto;
			}
		}
		return appDto;
	}

}
