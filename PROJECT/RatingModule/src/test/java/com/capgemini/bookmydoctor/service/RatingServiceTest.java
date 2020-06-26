package com.capgemini.bookmydoctor.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bookmydoctor.dto.Rating;

@SpringBootTest
class RatingServiceTest {
	@Autowired
	private RatingService service;
	Rating bean = null;
	boolean addRatingAndReview = false;

	@BeforeEach
	void addRatingAndReview() {
		bean = new Rating();
		bean.setDoctorId(120);
		bean.setDoctorName("Mark");
		bean.setRating(4);
		bean.setReview("good"); 
		addRatingAndReview = service.addRatingAndReview(bean); 
	}
	
	@Test
	void testAddRatingAndReview() {
		assertTrue(addRatingAndReview);
	}

	@AfterEach
	void testDeleteRatingAndReview() {
		service.deleteRatingAndReview(bean.getAppionmentId());
		
	}

	@Test
	void testGetAllRatingAndReviews() {
		List<Rating> list = service.getAllRatingAndReviews();
		assertNotNull(list);
	}

	@Test
	void testSearchRating() {
		Rating list = service.searchRating(bean.getAppionmentId());
		assertNotNull(list);
	}

	@Test
	void testModifyRating() {
		bean.getAppionmentId();
		assertTrue(service.modifyRating(bean));
		bean.setDoctorId(150);
		bean.setDoctorName("Markk");
		bean.setRating(5);
		bean.setReview(" very good"); 
		
	}
}
