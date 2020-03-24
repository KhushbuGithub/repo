package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.AppointmentDto;

public interface AppointmentDao {
	
	 public boolean registerAppointment(AppointmentDto appointment);

     public  boolean deleteAppointment(int appointmentId);
     
     public boolean updateAppointment(AppointmentDto appointment);
     
     public AppointmentDto getAppointment(int appointmentId);
     
     List<AppointmentDto> getAllAppointment(); 
     
     List<AppointmentDto>  getAppointmentById(Integer id);

}
