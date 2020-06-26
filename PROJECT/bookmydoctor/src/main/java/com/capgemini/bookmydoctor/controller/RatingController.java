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

import com.capgemini.bookmydoctor.dto.Rating;
import com.capgemini.bookmydoctor.dto.RatingResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class RatingController {

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/template/add-ratingandreview", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse addDoctor(@RequestBody Rating bean) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Rating> entity = new HttpEntity<Rating>(bean, headers);

		return restTemplate
				.exchange("http://localhost:8084/add-ratingandreview", HttpMethod.POST, entity, RatingResponse.class)
				.getBody();

	}

	@DeleteMapping(path = "/template/delete-ratingandreview/{ratingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse deleteRatingAndReview(@PathVariable("ratingId") int ratingId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RatingResponse> entity = new HttpEntity<RatingResponse>(headers);
		return restTemplate.exchange("http://localhost:8084/delete-ratingandreview/" + ratingId, HttpMethod.DELETE,
				entity, RatingResponse.class).getBody();

	}

	@GetMapping(path = "/template/get-allratingandreviews", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse getAllRatingAndReviews() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RatingResponse> entity = new HttpEntity<RatingResponse>(headers);
		return restTemplate
				.exchange("http://localhost:8084/get-allratingandreviews", HttpMethod.GET, entity, RatingResponse.class)
				.getBody();

	}

	@GetMapping(path = "/template/search-ratingandreview/{ratingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse searchRatingAndReview(@PathVariable("ratingId") int ratingId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RatingResponse> entity = new HttpEntity<RatingResponse>(headers);
		return restTemplate.exchange("http://localhost:8084/search-ratingandreview/" + ratingId, HttpMethod.GET, entity,
				RatingResponse.class).getBody();

	}

	@PutMapping(path = "/template/modify-ratingandreview", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse modifyRatingAndReview(@RequestBody Rating bean) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Rating> entity = new HttpEntity<Rating>(bean, headers);
		return restTemplate
				.exchange("http://localhost:8084/modify-ratingandreview", HttpMethod.PUT, entity, RatingResponse.class)
				.getBody();
	}

	@GetMapping(path = "/template/get-ratingbyname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RatingResponse getRatingByName(@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RatingResponse> entity = new HttpEntity<RatingResponse>(headers);
		return restTemplate.exchange("http://localhost:8084/get-ratingbyname/" + name, HttpMethod.GET, entity,
				RatingResponse.class).getBody();
	}

}
