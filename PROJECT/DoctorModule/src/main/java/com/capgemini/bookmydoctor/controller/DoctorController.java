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

import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.DoctorResponse;
import com.capgemini.bookmydoctor.service.DoctorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class DoctorController {

	@Autowired
	DoctorService service;

	@PostMapping(path = "/add-doctor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse addDoctor(@RequestBody Doctor bean) {
		DoctorResponse response = new DoctorResponse();
		if (service.addDoctor(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Doctor with this Id already exists");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-doctor/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse deleteDoctor(@PathVariable("doctorId") int doctorId) {
		DoctorResponse response = new DoctorResponse();
		if (service.deleteDoctor(doctorId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Doctor not found");
		}
		return response;
	}

	@GetMapping(path = "/get-alldoctors", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse getAllDoctors() {
		DoctorResponse response = new DoctorResponse();
		List<Doctor> list = service.getAllDoctors();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor Found");
			response.setBean(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}

	@GetMapping(path = "/search-doctorCity/{doctorCity}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse searchDoctor(@PathVariable("doctorCity") String doctorCity) {
		DoctorResponse response = new DoctorResponse();
		List<Doctor> bean = service.searchDoctor1(doctorCity);
		if (bean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor found");
			response.setBean(bean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Docter not exist");
		}
		return response;
	}

	@PutMapping(path = "/modify-doctor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse modifyDoctor(@RequestBody Doctor bean) {
		DoctorResponse response = new DoctorResponse();
		if (service.modifyDoctor(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor Details modified");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Unable to modify the Doctor Details");
		}
		return response;
	}

	@GetMapping(path = "/view-doctor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse viewPatient(@PathVariable("id") int id) {
		DoctorResponse response = new DoctorResponse();
		Doctor doctor = service.serarchDoctor(id);
		if (doctor != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Doctor found");
			response.setBean(Arrays.asList(doctor));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("DoctorId does not exist");
		}
		return response;
	}

}
