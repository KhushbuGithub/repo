package com.capgemini.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.springmvc.beans.User;

@Controller
public class SpringController {
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView map= new  ModelAndView();
		map.setViewName("/index");
        map.addObject("msg","Hello World...........");
		return map;
	}// end of hello

	// query string
	@GetMapping("/query")
	public String query(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "age", required = false) Integer age, ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("age", age);
		return "query";
	}// end of query string

	@GetMapping("/form")
	public String form() {
		return "form";
	}
//     @PostMapping("/form")
//	public String form(String name, String email, String password, long mobno, ModelMap map) {
//		map.addAttribute("name", name);
//		map.addAttribute("email", email);
//		map.addAttribute("password", password);
//		map.addAttribute("mobile", mobno);
//		return "form-data";
//	}

	// form
	@PostMapping("/form")
	public String form(User user, ModelMap map) {
		map.addAttribute("name", user.getName());
		map.addAttribute("email", user.getEmail());
		map.addAttribute("password", user.getPassword());
		map.addAttribute("mobno", user.getMobno());
		return "form-data";
	}// end of form

	@GetMapping("/path/{name}")
	public String path(@PathVariable("name") String name, ModelMap map) {
		map.addAttribute("name", name);
		return "path";
	}// end of path

	@GetMapping("/create-cookie")
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("name", "Prabhas");
		cookie.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(cookie);
		return "create-cookie";
	}// end of create-cookie

	@GetMapping("/read-cookie")
	public String readCookie(@CookieValue(name="name",required = false) String name, ModelMap map) {
		return "read-cookie";
	}// end of read-cookie
	
	@GetMapping("/forward")
	public String forward() {
		return "forward:hello";
	}//end of forward
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:http://www.google.com";
	}// end of redirect

}// end of spring controller
