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

import com.capgemini.bookmydoctor.dto.Doctor;
import com.capgemini.bookmydoctor.dto.DoctorResponse;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class DoctorController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/template/add-doctor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse addDoctor(@RequestBody Doctor bean) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Doctor> entity = new HttpEntity<Doctor>(bean, headers);

		return restTemplate.exchange("http://localhost:8082/add-doctor", HttpMethod.POST, entity, DoctorResponse.class)
				.getBody();

	}

	@DeleteMapping(path = "/template/delete-doctor/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse deleteDoctor(@PathVariable("doctorId") int doctorId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<DoctorResponse> entity = new HttpEntity<DoctorResponse>(headers);
		return restTemplate.exchange("http://localhost:8082/delete-doctor/" + doctorId, HttpMethod.DELETE, entity,
				DoctorResponse.class).getBody();

	}

	@GetMapping(path = "template/get-alldoctors", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse getAllDoctors() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<DoctorResponse> entity = new HttpEntity<DoctorResponse>(headers);
		return restTemplate
				.exchange("http://localhost:8082/get-alldoctors", HttpMethod.GET, entity, DoctorResponse.class)
				.getBody();

	}

//	@GetMapping(path = "/search-doctor/{doctorCity}/{doctorSpecialization}/{doctorgender}/{language1}/{language2}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public DoctorResponse searchDoctor(@PathVariable("doctorCity") String doctorCity,@PathVariable("doctorSpecialization") String doctorSpecialization,
//	@PathVariable("doctorgender") String doctorgender,@PathVariable("language1") String language1,@PathVariable("language2") String language2){
//		DoctorResponse response = new DoctorResponse();
//		List<Doctor> bean = service.searchDoctor(doctorCity, doctorSpecialization, doctorgender, language1, language2);
//		if (bean != null) {
//			response.setStatusCode(201);
//			response.setMessage("Success");
//			response.setDescription("Doctor found");
//			response.setBean(bean);
//		} else {
//			response.setStatusCode(401);
//			response.setMessage("Failure");
//			response.setDescription("Docter Id does not exist");
//		}
//		return response;
//	}

	@GetMapping(path = "/template/search-doctorCity/{doctorCity}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse searchDoctor(@PathVariable("doctorCity") String doctorCity) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<DoctorResponse> entity = new HttpEntity<DoctorResponse>(headers);
		return restTemplate.exchange("http://localhost:8082/search-doctorCity/" + doctorCity, HttpMethod.GET, entity,
				DoctorResponse.class).getBody();

	}

	@PutMapping(path = "/template/modify-doctor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse modifyDoctor(@RequestBody Doctor bean) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Doctor> entity = new HttpEntity<Doctor>(bean, headers);

		return restTemplate.exchange("http://localhost:8082/modify-doctor", HttpMethod.PUT, entity, DoctorResponse.class)
				.getBody();

	}

	@GetMapping(path = "/template/view-doctor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DoctorResponse viewPatient(@PathVariable("id") int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<DoctorResponse> entity = new HttpEntity<DoctorResponse>(headers);
		return restTemplate
				.exchange("http://localhost:8082/view-doctor/" + id, HttpMethod.GET, entity, DoctorResponse.class)
				.getBody();
	}

}
