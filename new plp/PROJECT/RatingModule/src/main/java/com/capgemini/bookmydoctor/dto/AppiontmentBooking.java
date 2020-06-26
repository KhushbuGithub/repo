package com.capgemini.bookmydoctor.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private String timeSlot;

	@Column
	private String appointmentDate;

	@Column
	private String doctorName;

	@OneToOne(cascade = CascadeType.ALL)
	private Rating rating;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId", referencedColumnName = "userId")
	private User patient;

	@ManyToOne
	@JoinColumn(name = "doctorId", referencedColumnName = "userId")
	private User doctor;

}
