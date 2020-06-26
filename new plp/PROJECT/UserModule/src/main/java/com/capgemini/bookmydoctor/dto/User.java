package com.capgemini.bookmydoctor.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class User {
	@Id
	@Column
	@GeneratedValue
	private int userId;

	@Column
	private String name;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private String userType;

	@OneToOne(cascade = CascadeType.ALL)
	private Patient patient;

	@OneToOne(cascade = CascadeType.ALL)
	private Doctor doctor;
}
