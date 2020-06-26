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

import com.capgemini.bookmydoctor.dto.AppiontmentBooking;
import com.capgemini.bookmydoctor.dto.AppiontmentBookingResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AppiontmentBookingController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/template/add-appiontment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse addAppiontment(@RequestBody AppiontmentBooking appiontment) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		HttpEntity<AppiontmentBooking> entity = new HttpEntity<AppiontmentBooking>(appiontment, headers);

		return restTemplate.exchange("http://localhost:8081/add-appiontment", HttpMethod.POST, entity,
				AppiontmentBookingResponse.class).getBody();

	}

	@GetMapping(path = "/template/view-appiontment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse viewAppiontment(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<AppiontmentBookingResponse> entity = new HttpEntity<AppiontmentBookingResponse>(headers);
		return restTemplate.exchange("http://localhost:8081/view-appiontment" + id, HttpMethod.GET, entity,
				AppiontmentBookingResponse.class).getBody();

	}

	@GetMapping(path = "/template/view-allappiontment", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse viewAllAppiontment() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<AppiontmentBookingResponse> entity = new HttpEntity<AppiontmentBookingResponse>(headers);
		return restTemplate.exchange("http://localhost:8081/view-allappiontment", HttpMethod.GET, entity,
				AppiontmentBookingResponse.class).getBody();
	}

	@DeleteMapping(path = "/template/delete-appiontment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse deleteAppiontment(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<AppiontmentBookingResponse> entity = new HttpEntity<AppiontmentBookingResponse>(headers);
		return restTemplate.exchange("http://localhost:8081/delete-appiontment" + id, HttpMethod.DELETE, entity,
				AppiontmentBookingResponse.class).getBody();
	}

	@GetMapping(path = "/template/get-appiontment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse getAppiontment(@PathVariable("id") int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<AppiontmentBookingResponse> entity = new HttpEntity<AppiontmentBookingResponse>(headers);
		return restTemplate.exchange("http://localhost:8081/get-appiontment" + id, HttpMethod.GET, entity,
				AppiontmentBookingResponse.class).getBody();

	}

	@GetMapping(path = "/template/get-appiontmentbyname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse getAppiontmentByName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8081/get-appiontmentbyname" + name, HttpMethod.GET, entity,
				AppiontmentBookingResponse.class).getBody();
	}

	@PutMapping(path = "/template/modify-Appiontment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse modifyAppiontment(@RequestBody AppiontmentBooking bean) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<AppiontmentBooking> entity = new HttpEntity<AppiontmentBooking>(bean, headers);
		return restTemplate.exchange("http://localhost:8081/modify-Appiontment", HttpMethod.PUT, entity,
				AppiontmentBookingResponse.class).getBody();
	}

}
