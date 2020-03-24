package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "availablity_info")
public class DoctorAvailablity {
	
	@Id
	@Column
	@GeneratedValue
	private int availabilityId;

	@Column
	private int doctorId;

	@Column
	private String fromDate;

	@Column
	private String toDate;

}
