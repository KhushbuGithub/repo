package com.capgemini.springwebsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springwebsecurity.bean.UserInfoBean;
import com.capgemini.springwebsecurity.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/register")
	public String getRegistrationForm() {
		return "register";

	}
	
	@GetMapping("/adminHomePage")
	public String getAdminHomePage() {
		return "adminHomePage";
	}
	
	@GetMapping("/userHomePage")
	public String getUserHomePage() {
		return "userHomePage";
	}

	@PostMapping("/register")
	public String register(UserInfoBean userInfoBean, ModelMap modelmap) {
		boolean isRegistered = service.register(userInfoBean);
		if (isRegistered) {
			modelmap.addAttribute("msg", "Registration Successfull");
		} else {
			modelmap.addAttribute("errMsg", "Registration Failed");
		}
		return "register";
	}

}
