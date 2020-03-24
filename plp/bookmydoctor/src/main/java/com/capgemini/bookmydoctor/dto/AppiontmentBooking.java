package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Appiontment_info")
public class AppiontmentBooking {
	
	@Id
	@Column
	@GeneratedValue
	private int appiontmentId;
	
	@Column
	private String patientName;
	
	@Column
    private double age;
	
	@Column
	private String diseaseSymptoms;
	
	@Column
	private String approval;
	
	@Column
	private int patientId;
	
	@Column
	private String timeSlot;
	
	@Column
	private String appointmentDate;
	
	@Column
	private String doctorName;
	
	@Column
	private int doctorId;
	
	

}
