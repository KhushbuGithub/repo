package com.capgemini.assignment.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.capgemini.assignment.dto.Employee;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "emp_address_info")
public class EmpAddressInfo implements Serializable {
	
	@EmbeddedId
	private EmpAddressPK addressPK;
	@Column
	private String house_no;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String landmark;
	@Column
	private String city;
	@Column
	private int pincode;
	
	@Exclude
	@MapsId("emp_id")
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private Employee primary;

}
