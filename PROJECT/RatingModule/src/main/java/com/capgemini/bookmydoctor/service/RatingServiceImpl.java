package com.capgemini.bookmydoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.RatingDAO;
import com.capgemini.bookmydoctor.dto.Rating;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	RatingDAO dao;

	@Override
	public boolean addRatingAndReview(Rating bean) {
		return dao.addRatingAndReview(bean);
	}

	@Override
	public boolean deleteRatingAndReview(int ratingId) {
		return dao.deleteRatingAndReview(ratingId);
	}

	@Override
	public List<Rating> getAllRatingAndReviews() {
		return dao.getAllRatingAndReviews();
	}

	@Override
	public Rating searchRating(int ratingId) {
		return dao.searchRating(ratingId);
	}

	@Override
	public boolean modifyRating(Rating bean) {
		return dao.modifyRating(bean);
	}

	@Override
	public List<Rating> searchRating(String doctorName) {
		return dao.searchRating(doctorName);
	}

}
