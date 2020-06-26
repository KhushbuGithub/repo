package com.capgemini.bookmydoctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "patient_info")
public class Patient {
	
	@Id
	@Column
	private int patientId;
	
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

}
