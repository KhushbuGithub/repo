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
@Table(name = "patient_info")
public class Patient {
	
	@Id
	private int userId;
	
	@Column
	private String patientName;
	
	@Column
	private String gender;
	
	@Column(unique = true )
	private String email;
	
	@Column
    private String password;
    
	@Column
    private double age;
    
	@Column
    private long mobileNumber;
    
	@Column
    private String location;
    
	@Column
    private String language;
    
	@Column
    private String termsAndCondition;
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
	private List<AppiontmentBooking> app;


}
