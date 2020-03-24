package com.capgemini.bookmydoctor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmydoctor.dto.DoctorAvailablity;
import com.capgemini.bookmydoctor.dto.DoctorAvailablityResponse;
import com.capgemini.bookmydoctor.service.DoctorAvailablityService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class DoctorAvailablityController {
	
	@Autowired
	DoctorAvailablityService service;

	@PostMapping(path = "/add-doctoravailability", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorAvailablityResponse addDoctorAvailability(@RequestBody DoctorAvailablity bean) {
		DoctorAvailablityResponse response = new DoctorAvailablityResponse();
		if (service.addDoctorAvailability(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription(" Doctor Availability added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Doctor Availability with this Id already exists");
		}
		return response;
	}
	
	@DeleteMapping(path = "/delete-doctoravailability/{availabilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorAvailablityResponse deleteDoctorAvailability(@PathVariable("availabilityId") int availabilityId) {
		DoctorAvailablityResponse response = new DoctorAvailablityResponse();
		if (service.deleteDoctorAvailability(availabilityId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription(" Doctor Availability deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Doctor Availability not found");
		}
		return response;
	}
	
	
	
	@GetMapping(path = "/get-allavailability", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorAvailablityResponse getAllDoctorAvailabilities() {
		DoctorAvailablityResponse response = new DoctorAvailablityResponse();
		List<DoctorAvailablity> list = service.getAllDoctorAvailabilities();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor Availability Found");
			response.setBean(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}
	
	
	@GetMapping(path = "/search-availability/{availabilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorAvailablityResponse searchDoctorAvailability(@PathVariable("availabilityId") int availabilityId) {
		DoctorAvailablityResponse response = new DoctorAvailablityResponse();
		DoctorAvailablity bean = service.searchDoctorAvailability(availabilityId);
		if (bean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor Availability found");
			response.setBean(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Availability Id does not exist");
		}
		return response;
	}
	
	
	@PutMapping(path = "/modify-availability", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorAvailablityResponse modifyDoctorAvailability(@RequestBody DoctorAvailablity bean) {
		DoctorAvailablityResponse response = new DoctorAvailablityResponse();
		if (service.modifyDoctorAvailability( bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription(" Doctor Availability modified");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Unable to modify the Doctor Availability Details");
		}
		return response;
	}


}
