package com.capgemini.ratingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ratingservice.beans.BookRating;
import com.capgemini.ratingservice.dao.RatingDao;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingDao dao; 

	@Override
	public BookRating getRating(int Id) {
		if (Id > 0)
			return dao.getRating(Id);
		else
			return null;
		
	}

	@Override
	public List<BookRating> getAllRating() {
		return dao.getAllRating();
	}

}
