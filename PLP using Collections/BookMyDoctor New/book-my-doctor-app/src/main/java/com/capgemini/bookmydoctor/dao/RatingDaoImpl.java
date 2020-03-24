package com.capgemini.bookmydoctor.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.bookmydoctor.db.MyDoctorDB;

import com.capgemini.bookmydoctor.dto.RatingDto;

public class RatingDaoImpl implements RatingDao {

	private LinkedList<RatingDto> ratingDto = MyDoctorDB.ratingDto;

	@Override
	public boolean registerRating(RatingDto rating) {
		for (RatingDto ratingInfoDto : ratingDto) {
			if (ratingInfoDto.getPatientId() == rating.getPatientId()) {
				return false;
			}
		}
		MyDoctorDB.ratingDto.add(rating);
		return true;
	}

	@Override
	public boolean deleteRating(int patientId) {
		RatingDto dto = null;
		for (RatingDto ratingInfoDto : ratingDto) {
			if (ratingInfoDto.getPatientId() == patientId) {
				dto = ratingInfoDto;
				MyDoctorDB.ratingDto.remove(dto);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateRating(RatingDto rating) {
		for (RatingDto ratingInfoDto : ratingDto) {
			if (ratingInfoDto.getDoctorId() == rating.getDoctorId()) {
				ratingInfoDto.setDoctorName(rating.getDoctorName());
				ratingInfoDto.setPatientId(rating.getPatientId());
				ratingInfoDto.setPatientName(rating.getPatientName());
				ratingInfoDto.setRating(rating.getRating());
				return true;
			}
		}
		return false;
	}

	@Override
	public RatingDto getRating(int patientId) {
		RatingDto dto = null;
		for (RatingDto ratingInfoDto : ratingDto) {
			if (ratingInfoDto.getPatientId() == patientId) {
				dto = ratingInfoDto;
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<RatingDto> getAllRating() {
		List<RatingDto> ratingDtos = ratingDto;
		return ratingDtos;
	}

}
