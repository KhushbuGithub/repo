package com.capgemini.springrestsecurity.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_info")
public class UserInfoBean {
	
	@Id
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private long mobile;

}
