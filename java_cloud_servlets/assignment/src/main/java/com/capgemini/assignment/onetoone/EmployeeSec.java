package com.capgemini.assignment.onetoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capgemini.assignment.dto.Employee;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name = "emp_Secondary_info")
public class EmployeeSec implements Serializable {

	public Employee getPrimary() {
		return primary;
	}

	public void setPrimary(Employee primary) {
		this.primary = primary;
	}

	@Id
	private int emp_id;
	@Column
	private String gender;
	@Column
	private String personal_email;
	@Column
	private String job_location;
	@Column
	private String married;
	@Column
	private String nationality;
	@Column
	private String guardian_name;
	@Column
	private String language_known;
	@Column
	private String blood_group;
	@Column
	private String govt_id;
 
	@Exclude
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private Employee primary;

//	public int getEmpId() {
//		return emp_id;
//	}
//
//	public int getEmp_id() {
//		return emp_id;
//	}
//
//	public void setEmp_id(int emp_id) {
//		this.emp_id = emp_id;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public String getPersonal_email() {
//		return personal_email;
//	}
//
//	public void setPersonal_email(String personal_email) {
//		this.personal_email = personal_email;
//	}
//
//	public String getJob_location() {
//		return job_location;
//	}
//
//	public void setJob_location(String job_location) {
//		this.job_location = job_location;
//	}
//
//	public String getMarried() {
//		return married;
//	}
//
//	public void setMarried(String married) {
//		this.married = married;
//	}
//
//	public String getNationality() {
//		return nationality;
//	}
//
//	public void setNationality(String nationality) {
//		this.nationality = nationality;
//	}
//
//	public String getGuardian_name() {
//		return guardian_name;
//	}
//
//	public void setGuardian_name(String guardian_name) {
//		this.guardian_name = guardian_name;
//	}
//
//	public String getLanguage_known() {
//		return language_known;
//	}
//
//	public void setLanguage_known(String language_known) {
//		this.language_known = language_known;
//	}
//
//	public String getBlood_group() {
//		return blood_group;
//	}
//
//	public void setBlood_group(String blood_group) {
//		this.blood_group = blood_group;
//	}
//
//	public String getGovt_id() {
//		return govt_id;
//	}
//
//	public void setGovt_id(String govt_id) {
//		this.govt_id = govt_id;
//	}

}
