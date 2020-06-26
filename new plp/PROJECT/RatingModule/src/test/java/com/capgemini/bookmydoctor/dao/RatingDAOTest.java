package com.capgemini.bookmydoctor.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.bookmydoctor.dto.Rating;

@SpringBootTest
class RatingDAOTest {
	
	@Autowired
	private RatingDAO dao;
	Rating bean = null;
	boolean addRatingAndReview = false;

	@BeforeEach
	void addRatingAndReview() {
		bean = new Rating();
		bean.setDoctorId(120);
		bean.setDoctorName("Mark");
		bean.setRating(4);
		bean.setReview("good"); 
		addRatingAndReview = dao.addRatingAndReview(bean); 
	}
	
	@Test
	void testAddRatingAndReview() {
		assertTrue(addRatingAndReview);
	}

	@AfterEach
	void testDeleteRatingAndReview() {
		dao.deleteRatingAndReview(bean.getAppionmentId());
		
	}

	@Test
	void testGetAllRatingAndReviews() {
		List<Rating> list = dao.getAllRatingAndReviews();
		assertNotNull(list);
	}

	@Test
	void testSearchRating() {
		Rating list = dao.searchRating(bean.getAppionmentId());
		assertNotNull(list);
	}

	@Test
	void testModifyRating() {
		bean.getAppionmentId();
		assertTrue(dao.modifyRating(bean));
		bean.setDoctorId(150);
		bean.setDoctorName("Markk");
		bean.setRating(5);
		bean.setReview(" very good"); 
		
	}

}
