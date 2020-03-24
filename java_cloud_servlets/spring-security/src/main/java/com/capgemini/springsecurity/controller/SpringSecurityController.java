package com.capgemini.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityController {
	
	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}
 
	@GetMapping("/adminHomePage")
	public String getAdminHomePage() {
		return "adminHomePage";
	}
 
	@GetMapping("/userHomePage")
	public String getUserHomePage() {
		return "userHomePage";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "LoginForm";
	}
 
}
