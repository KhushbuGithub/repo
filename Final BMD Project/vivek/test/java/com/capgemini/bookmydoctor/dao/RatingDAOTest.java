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
		bean.setDoctorName("Nisha");
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
		dao.deleteRatingAndReview(bean.getRatingId());
	}

	@Test
	void testGetAllRatingAndReviews() {
		List<Rating> list = dao.getAllRatingAndReviews();
		assertNotNull(list);
	}

	@Test
	void testSearchRating() {
		Rating list = dao.searchRating(bean.getRatingId());
		assertNotNull(list);
	}

	@Test
	void testModifyRating() {
		bean.getRatingId();
		assertTrue(dao.modifyRating(bean));
		bean.setDoctorId(150);
		bean.setDoctorName("Anusha");
		bean.setRating(5);
		bean.setReview(" very good"); 
		
	}

}
