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

import com.capgemini.bookmydoctor.dto.Rating;
import com.capgemini.bookmydoctor.dto.RatingResponse;
import com.capgemini.bookmydoctor.service.RatingService;

@CrossOrigin(origins = "*", allowedHeaders ="*" ,allowCredentials = "true")
@RestController
public class RatingController {
	
	@Autowired
	RatingService service;

	@PostMapping(path = "/add-ratingandreview", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse addDoctor(@RequestBody Rating bean) {
		RatingResponse response = new RatingResponse();
		if (service.addRatingAndReview(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Rating And Review added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("RatingAndReview with this Id already exists");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-ratingandreview/{ratingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse deleteRatingAndReview(@PathVariable("ratingId") int ratingId) {
		RatingResponse response = new RatingResponse();
		if (service.deleteRatingAndReview(ratingId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Rating And Review deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("RatingAndReview not found");
		}
		return response;
	}

	@GetMapping(path = "/get-allratingandreviews", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse getAllRatingAndReviews() {
		RatingResponse response = new RatingResponse();
		List<Rating> list = service.getAllRatingAndReviews();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Rating And Review Found");
			response.setBean(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}

	@GetMapping(path = "/search-ratingandreview/{ratingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse searchRatingAndReview(@PathVariable("ratingId") int ratingId) {
		RatingResponse response = new RatingResponse();
		Rating bean = service.searchRating(ratingId);
		if (bean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Rating And Review found");
			response.setBean(Arrays.asList(bean));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Rating Id does not exist");
		}
		return response;
	}

	@PutMapping(path = "/modify-ratingandreview", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse modifyRatingAndReview(@RequestBody Rating bean) {
		RatingResponse response = new RatingResponse();
		if (service.modifyRating(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Rating And Review edited");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Unable to edit the Rating And Review");
		}
		return response;
	}
	@GetMapping(path = "/get-ratingbyname/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse getRatingByName(@PathVariable("id") String name) {
		RatingResponse response = new RatingResponse();
		List<Rating> list=service.searchRating(name);
		if(list != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("rating found");
			response.setBean(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("rating does not exist");
		}
		return response;
	}


}
