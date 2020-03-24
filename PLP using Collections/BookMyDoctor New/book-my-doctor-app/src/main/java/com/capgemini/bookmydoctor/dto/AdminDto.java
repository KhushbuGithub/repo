package com.capgemini.bookmydoctor.dto;

import lombok.Data;

@Data
public class AdminDto {
	
	private int adminId;
	private String adminName;
	private String adminEmailId;
	private String password;

}
