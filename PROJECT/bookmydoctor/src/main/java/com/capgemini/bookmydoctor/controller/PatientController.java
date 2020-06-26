package com.capgemini.bookmydoctor.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.bookmydoctor.dto.Patient;
import com.capgemini.bookmydoctor.dto.PatientResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class PatientController {

	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/template/add-patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse addPatient(@RequestBody Patient patient) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Patient> entity = new HttpEntity<Patient>(patient, headers);
		
		return restTemplate
				.exchange("http://localhost:8083/add-patient", HttpMethod.POST, entity, PatientResponse.class)
				.getBody();
	}

	@GetMapping(path = "/template/view-patient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse viewPatient(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PatientResponse> entity = new HttpEntity<PatientResponse>(headers);
		return restTemplate
				.exchange("http://localhost:8083/view-patient/"+id, HttpMethod.GET, entity, PatientResponse.class)
				.getBody();
	}

	@GetMapping(path = "/template/view-allpatients", produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse viewAllPatients() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PatientResponse> entity = new HttpEntity<PatientResponse>(headers);
		return restTemplate
				.exchange("http://localhost:8083/view-allpatient", HttpMethod.GET, entity, PatientResponse.class)
				.getBody();
	}

	@DeleteMapping(path = "/template/delete-patient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse deletePatient(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PatientResponse> entity = new HttpEntity<PatientResponse>(headers);
		return restTemplate
				.exchange("http://localhost:8083/delete-patient/"+id, HttpMethod.DELETE, entity, PatientResponse.class)
				.getBody();
	}

	@PutMapping(path = "/template/modify-Patient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PatientResponse modifyPatient(@RequestBody Patient bean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Patient> entity = new HttpEntity<Patient>(bean, headers);
		return restTemplate
				.exchange("http://localhost:8083/modify-Patient", HttpMethod.PUT, entity, PatientResponse.class)
				.getBody();
	}

}
