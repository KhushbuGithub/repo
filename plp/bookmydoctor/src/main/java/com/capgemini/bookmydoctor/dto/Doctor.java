package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "doctor_info")
public class Doctor {
	@Id
	@Column
	private int doctorId;

	@Column
	private String doctorName;

	@Column
	private String gender;

	@Column(unique = true)
	private String email;

	@Column
	private int age;

	@Column
	private String specialization;

	@Column
	private String language1;
	
	@Column
	private String language2;
	
	@Column
	private String homeAddress;
	
	@Column
	private String officeAddress;
	
	@Column
	private String city;

	@Column
	private int zipCode;
	
	@Column
	private long phoneNumber;

	@Column
	private String aboutDoctor;

	@Column
	private String doctorImage;

	@Column
	private String termsAndCondition;

	@Column
	private String password;

}



