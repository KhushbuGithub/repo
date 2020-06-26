package com.capgemini.bookmydoctor.service;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Rating;

public interface RatingService {
	public boolean addRatingAndReview(Rating bean);

	public boolean deleteRatingAndReview(int ratingId);

	public List<Rating> getAllRatingAndReviews();

	public Rating searchRating(int ratingId);

	public boolean modifyRating(Rating bean);
	
	public List<Rating> searchRating(String doctorName);

}
