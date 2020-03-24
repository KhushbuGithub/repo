package com.capgemini.bookmydoctor.dao;

import java.util.List;

import com.capgemini.bookmydoctor.dto.RatingDto;

public interface RatingDao {
	
	public boolean registerRating(RatingDto rating);

    public  boolean deleteRating(int ratingId);
    
    public boolean updateRating(RatingDto rating);
    
    public RatingDto getRating(int ratingId);
    
    List<RatingDto> getAllRating();

}
