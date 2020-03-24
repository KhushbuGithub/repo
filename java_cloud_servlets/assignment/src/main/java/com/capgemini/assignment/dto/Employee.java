package com.capgemini.assignment.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capgemini.assignment.manytomany.ProjectInfo;
import com.capgemini.assignment.manytoone.EmpAddressInfo;
import com.capgemini.assignment.onetoone.EmployeeSec;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_primary_info")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column
	 private int emp_id;
	@Column
	 private String emp_name;
	@Column
	private String salary;
	@Column
	 private int dept_id;
	@Column
	 private double phone_no;
	@Column
	 private String official_mail;
	@Column
	 private String designation;
	@Column
	 private int manager_id;
	@Column
	 private double experience;
	@Column(name = "DOB")
	Date dob;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy = "primary")
	private EmployeeSec secondary;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="primary")
	private List< EmpAddressInfo> addinfo;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "employee")
	private List<ProjectInfo> projectinfo;
	

//	public int getEmp_id() {
//		return emp_id;
//	}
//
//	public void setEmp_id(int emp_id) {
//		this.emp_id = emp_id;
//	}
//
//	public String getEmp_name() {
//		return emp_name;
//	}
//
//	public void setEmp_name(String emp_name) {
//		this.emp_name = emp_name;
//	}
//
//	public String getSalary() {
//		return salary;
//	}
//
//	public void setSalary(String salary) {
//		this.salary = salary;
//	}
//
//	public int getDept_id() {
//		return dept_id;
//	}
//
//	public void setDept_id(int dept_id) {
//		this.dept_id = dept_id;
//	}
//
//	public double getPhone_no() {
//		return phone_no;
//	}
//
//	public void setPhone_no(double phone_no) {
//		this.phone_no = phone_no;
//	}
//
//	public String getOfficial_mail() {
//		return official_mail;
//	}
//
//	public void setOfficial_mail(String official_mail) {
//		this.official_mail = official_mail;
//	}
//
//	public String getDesignation() {
//		return designation;
//	}
//
//	public void setDesignation(String designation) {
//		this.designation = designation;
//	}
//
//	public int getManager_id() {
//		return manager_id;
//	}
//
//	public void setManager_id(int manager_id) {
//		this.manager_id = manager_id;
//	}
//
//	public double getExperience() {
//		return experience;
//	}
//
//	public void setExperience(double experience) {
//		this.experience = experience;
//	}
//
//	public Date getDob() {
//		return dob;
//	}
//
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}

}
