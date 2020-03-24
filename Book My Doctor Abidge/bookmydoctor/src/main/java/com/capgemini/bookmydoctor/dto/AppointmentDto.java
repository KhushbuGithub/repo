package com.capgemini.bookmydoctor.dto;

import java.sql.Date;
import java.sql.Time;

public class AppointmentDto {

	private int appointmentId;
	private int doctorId;
	private int numberOfInPatients;
	private int numberOfOutPatients;
	private Date appointmentDate;
	private Time appointmentTime;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public int getNumberOfInPatients() {
		return numberOfInPatients;
	}

	public void setNumberOfInPatients(int numberOfInPatients) {
		this.numberOfInPatients = numberOfInPatients;
	}

	public int getNumberOfOutPatients() {
		return numberOfOutPatients;
	}

	public void setNumberOfOutPatients(int numberOfOutPatients) {
		this.numberOfOutPatients = numberOfOutPatients;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Time getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
}
