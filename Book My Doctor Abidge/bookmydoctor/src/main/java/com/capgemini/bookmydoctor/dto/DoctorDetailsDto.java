package com.capgemini.bookmydoctor.dto;

import java.sql.Date;
import java.sql.Time;

public class DoctorDetailsDto {

	private int doctorId;
	private String doctorName;
	private String specialization;
	private int yearOfExperience;
	private String availabilityFromDay;
	private String availabilityEndDay;
	private Time availabilityStartTime;
	private Time availabilityEndTime;
	private int charges;
	private int rating;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	public String getAvailabilityFromDay() {
		return availabilityFromDay;
	}

	public void setAvailabilityFromDay(String availabilityFromDay) {
		this.availabilityFromDay = availabilityFromDay;
	}

	public String getAvailabilityEndDay() {
		return availabilityEndDay;
	}

	public void setAvailabilityEndDay(String availabilityEndDay) {
		this.availabilityEndDay = availabilityEndDay;
	}
	
	public Time getAvailabilityStartTime() {
		return availabilityStartTime;
	}

	public void setAvailabilityStartTime(Time availabilityStartTime) {
		this.availabilityStartTime = availabilityStartTime;
	}

	public Time getAvailabilityEndTime() {
		return availabilityEndTime;
	}

	public void setAvailabilityEndTime(Time availabilityEndTime) {
		this.availabilityEndTime = availabilityEndTime;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
