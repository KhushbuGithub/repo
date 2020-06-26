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

import com.capgemini.bookmydoctor.dto.AppiontmentBooking;
import com.capgemini.bookmydoctor.dto.AppiontmentBookingResponse;
import com.capgemini.bookmydoctor.service.AppiontmentBookingService;

@CrossOrigin(origins = "*", allowedHeaders ="*" ,allowCredentials = "true")
@RestController
public class AppiontmentBookingController {
	
	@Autowired
	AppiontmentBookingService service;
	
	@PostMapping(path="/add-appiontment",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse addAppiontment(@RequestBody AppiontmentBooking appiontment) {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		if(service.addAppiontment(appiontment)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Appiontment Booked successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Appiontment already booked");
		}
		return response;
	}
	
	@GetMapping(path="/view-appiontment/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse viewAppiontment(@PathVariable("id") int id) {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		AppiontmentBooking appiontment=service.serarchAppiontment(id);
		if(appiontment != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Appiontment found");
			response.setAppiontmentBooking(Arrays.asList(appiontment));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Appiontment does not exist");
		}
		return response;
	}
	
	@GetMapping(path="/view-allappiontment",produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse  viewAllAppiontment() {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		List<AppiontmentBooking> list=service.getAllAppiontments();
		if(list.size()!=0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Appiontment details found");
			response.setAppiontmentBooking(list);

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Appiontment details not found");
		}
		return response;

	}
	
	@DeleteMapping(path = "/delete-appiontment/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse deleteAppiontment(@PathVariable("id") int id) {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		if(service.deleteAppiontment(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Appiontment deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Appiontment not found");
		}
		return response;
	}
	@GetMapping(path = "/get-appiontment/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse getAppiontment(@PathVariable("id") int id) {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		List<AppiontmentBooking> list=service.getAppiontments(id);
		if(list != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Appiontment found");
			response.setAppiontmentBooking(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Appiontment does not exist");
		}
		return response;
	}
	@GetMapping(path = "/get-appiontmentbyname/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse getAppiontmentByName(@PathVariable("id") String name) {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		List<AppiontmentBooking> list=service.getAppiontmentsByName(name);
		if(list != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Appiontment found");
			response.setAppiontmentBooking(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Appiontment does not exist");
		}
		return response;
	}
	
	@PutMapping(path = "/modify-Appiontment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppiontmentBookingResponse modifyAppiontment(@RequestBody AppiontmentBooking bean) {
		AppiontmentBookingResponse response = new AppiontmentBookingResponse();
		if (service.modifyAppiontment(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Appiontment Details modified");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Unable to modify the Appiontment Details");
		}
		return response;
	}

}
