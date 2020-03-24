package com.capgemini.bookmydoctor.service;

import java.util.List;

import com.capgemini.bookmydoctor.dao.RatingDao;
import com.capgemini.bookmydoctor.dto.RatingDto;
import com.capgemini.bookmydoctor.factory.DaoFactory;

public class RatingServiceImpl implements RatingService {
	
	private RatingDao dao= DaoFactory.getRatingDao();

	@Override
	public boolean registerRating(RatingDto rating) {
		return dao.registerRating(rating);
	}

	@Override
	public boolean deleteRating(int ratingId) {
		return dao.deleteRating(ratingId);
	}

	@Override
	public boolean updateRating(RatingDto rating) {
		return dao.registerRating(rating);
	}

	@Override
	public RatingDto getRating(int ratingId) {
		return dao.getRating(ratingId);
	}

	@Override
	public List<RatingDto> getAllRating() {
		return dao.getAllRating();
	}

}
