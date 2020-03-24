package com.capgemini.assignment.manytoone;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Immutable;

import lombok.Data;
 @Data
 @Embeddable
public class EmpAddressPK implements Serializable {
	private int emp_id;
	private String address_type;
	
	
	
	
	

}
