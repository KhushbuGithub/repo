package com.capgemini.bookmydoctor.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL)
//	private Rating rating;
//	
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId",referencedColumnName = "userId")
//	private Patient patient;
//	
//	@JsonIgnore
//	@ManyToOne
//	@JoinColumn(name = "userId",referencedColumnName = "userId")
//	private Doctor doctor;
//	
	

}
