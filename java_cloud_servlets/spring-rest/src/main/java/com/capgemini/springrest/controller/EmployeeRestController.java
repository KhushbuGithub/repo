package com.capgemini.springrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrest.dto.EmployeeInfoBean;
import com.capgemini.springrest.dto.EmployeeResponse;
import com.capgemini.springrest.service.EmployeeService;

import lombok.EqualsAndHashCode;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/search",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse search(@RequestParam("name") String name) {
		List<EmployeeInfoBean> beans = service.search(name);
		EmployeeResponse response = new EmployeeResponse();
		if (beans != null && !beans.isEmpty()) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription("data found in db for the request");
			response.setBeans(beans);
		} else {
			response.setStatuscode(401);
			response.setMessage("Failure");
			response.setDescription("data not found in db for the request");
		}
		return response;
	}

	@PostMapping(path = "/register", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse register(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.register(bean)) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription("data  inserted into db for the request");
		} else {
			response.setStatuscode(401);
			response.setMessage("Failure");
			response.setDescription("data not inserted in db for the request");
		}
		return response;
	}

	@PostMapping(path = "/path",
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse auth(@RequestBody EmployeeInfoBean bean) {
		EmployeeInfoBean infobean = service.auth(bean.getEmail(), bean.getPassword());
		EmployeeResponse response = new EmployeeResponse();
		if (infobean != null) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription(" Valid Credential");
			response.setBeans(Arrays.asList(infobean));
		} else {
			response.setStatuscode(201);
			response.setMessage("Failure");
			response.setDescription(" Invalid Credential");
		}
		return response;
	}

	@PutMapping(path = "/change-password",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse changePassword(@RequestBody EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.changePassword(bean.getId(), bean.getPassword())) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription(" password changed in db for the request");
		} else {
			response.setStatuscode(401);
			response.setMessage("Failure");
			response.setDescription("password not changed in db for the request");
		}
		return response;
	}

	@DeleteMapping(path = "/delete/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@PathVariable("id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.deleteEmployee(id)) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription(" data deleted in db for the request");
		} else {
			response.setStatuscode(401);
			response.setMessage("Failure");
			response.setDescription("data not deleted in db for the request");

		}
		return response;
	}

}
