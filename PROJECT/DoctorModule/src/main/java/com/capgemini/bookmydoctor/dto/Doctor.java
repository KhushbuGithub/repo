package com.capgemini.bookmydoctor.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "doctor_info")
public class Doctor {
	@Id
	private int userId;

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
	private long phoneNumber;

	@Column
	private String doctorImage;

	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@MapsId
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
	private List<AppiontmentBooking> app;

}
