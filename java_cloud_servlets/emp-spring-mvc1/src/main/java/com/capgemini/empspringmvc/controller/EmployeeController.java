package com.capgemini.empspringmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.empspringmvc.dto.EmployeeInfoBean;
import com.capgemini.empspringmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/login")
	public String login(@SessionAttribute(name = "bean", required = false) EmployeeInfoBean bean) {
		if(bean != null) {
			return "home";
		}
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, String email, String password) {
		EmployeeInfoBean bean = service.auth(email, password);
		if (bean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("bean", bean);
			return "home";
		} else {
			request.setAttribute("msg", "Invalid Credentials");
			return "login";
		}
	}

	@GetMapping("/register")
	public String register(@SessionAttribute(name = "bean", required = false) EmployeeInfoBean bean) {
		if (bean != null) {
			if (bean.getRole().equals("ADMIN")) {
				return "register";
			} else {
				return "home";
			}
		}
		return "login";
	}

	@PostMapping("/register")
	public String register(EmployeeInfoBean bean, ModelMap map) {
		if (service.register(bean)) {
			return "home";
		} else {
			map.addAttribute("msg", "Email already exist");
			return "register";
		}
	}

	@GetMapping("/home")
	public String home(@SessionAttribute(name = "bean", required = false) EmployeeInfoBean bean) {
		if (bean != null) {
			return "home";
		}
		return "login";
	}

	@GetMapping("/change-password")
	public String changePassword(@SessionAttribute(name = "bean", required = false) EmployeeInfoBean bean) {
		if (bean != null) {
			return "change-password";
		}
		return "login";

	}

	@PostMapping("/change-password")
	public String changePassword(String password, @SessionAttribute("bean") EmployeeInfoBean bean) {
		service.changePassword(bean.getId(), password);
		return "home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

	@GetMapping("/search")
	public String search(@SessionAttribute(name = "bean", required = false) EmployeeInfoBean bean,
			@RequestParam(name = "name", required = false) String name, ModelMap map) {
		if (bean != null) {
			if (name != null) {
				List<EmployeeInfoBean> beans = service.search(name);
				map.addAttribute("beans", beans);
			}
			return "home";
		} else {
			return "login";
		}
	}
}
