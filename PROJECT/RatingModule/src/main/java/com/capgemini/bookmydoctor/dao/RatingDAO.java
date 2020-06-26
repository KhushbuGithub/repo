package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.Rating;

public interface RatingDAO {
	public boolean addRatingAndReview(Rating bean);

	public boolean deleteRatingAndReview(int ratingId);

	public List<Rating> getAllRatingAndReviews();

	public Rating searchRating(int ratingId);

	public List<Rating> searchRating(String doctorName);

	public boolean modifyRating(Rating bean);

}
