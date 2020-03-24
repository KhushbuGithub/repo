package com.capgemini.assignment.manytomany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.capgemini.assignment.dto.Employee;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="project_info")
public class ProjectInfo implements Serializable {
	@Id
	@Column
	private int project_id;
	@Column
	private String project_name;
	@Column
	private String location;
	@Column
	private int duration;
	@Column
	private String technology;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="project_emp",joinColumns = @JoinColumn(name="project_id"),
	inverseJoinColumns = @JoinColumn(name="emp_id"))
	private List<Employee> primary;
	
	

}
