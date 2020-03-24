package com.capgemini.springmvc.beans;

import lombok.Data;

@Data
public class User {
	private String name;
	private String  email;
	private String password;
	private long mobno;

}
