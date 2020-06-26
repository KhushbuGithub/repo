package com.capgemini.bookmydoctor.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rating_info")
public class Rating {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue
	private int appionmentId;

	@Column
	private int doctorId;
	
	@Column
	private int patientId;
	
	@Column
	private String patientName;

	@Column
	private String doctorName;

	@Column
	private int rating;

	@Column
	private String review;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appiontmentId")
	private AppiontmentBooking appiontment;

}
