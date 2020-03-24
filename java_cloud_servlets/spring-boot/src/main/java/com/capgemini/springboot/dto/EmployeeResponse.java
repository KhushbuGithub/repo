package com.capgemini.springboot.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeResponse {
	private int statuscode;
	private String message;
	private String description;
	private List<EmployeeInfoBean> beans;

}
