
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

import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.dto.PatientResponse;
import com.capgemini.bookmydoctor.dto.User;
import com.capgemini.bookmydoctor.service.PatientService;

@CrossOrigin(origins = "*", allowedHeaders ="*" ,allowCredentials = "true")
@RestController
public class PatientController {
	
	@Autowired
	private PatientService service;

	@PostMapping(path="/add-patient",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse addPatient(@RequestBody Patient patient) {
		PatientResponse response = new PatientResponse();
	
		if(service.addPatient(patient)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Patient added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Patient already exists");
		}
		return response;
	}
	
	@GetMapping(path="/view-patient/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse viewPatient(@PathVariable("id") int id) {
		PatientResponse response = new PatientResponse();
		Patient patient=service.serarchPatient(id);
		if(patient != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Patient found");
			response.setPatient(Arrays.asList(patient));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("PatientId does not exist");
		}
		return response;
	}
	
	@GetMapping(path="/view-allpatients",produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse viewAllPatients() {
		PatientResponse response = new PatientResponse();
		List<Patient> list=service.getAllPatients();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Patients details found");
			response.setPatient(list);

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Patients details not found");
		}
		return response;

	}
	
	@DeleteMapping(path = "/delete-patient/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse deletePatient(@PathVariable("id") int id) {
		PatientResponse response = new PatientResponse();
		if(service.deletePatient(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Patient deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Patient not found");
		}
		return response;
	}
	
	@PutMapping(path = "/modify-Patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse modifyPatient(@RequestBody Patient bean) {
		PatientResponse response = new PatientResponse();
		if (service.modifyPatient(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Patient Details modified");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Unable to modify the Patient Details");
		}
		return response;
	}

}
