package com.capgemini.bookmydoctor.daotest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.bookmydoctor.dao.RatingDao;
import com.capgemini.bookmydoctor.dao.RatingDaoImpl;
import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.RatingDto;
import com.capgemini.bookmydoctor.exceptions.ValidInputException;

class RatingDaoImplTest {

	private RatingDto dto = new RatingDto();
	private RatingDao dao = new RatingDaoImpl();

	@Test
	public void registerRatingTest() {
		try {
			dto.setRating("Good");
			dto.setDoctorId(101);
			dto.setDoctorName("ASD");
			dto.setPatientId(223);
			dto.setPatientName("XYZ");
			boolean expectedFlag = dao.registerRating(dto);
			assertEquals(expectedFlag, true);
			MyDoctorDB.ratingDto.add(dto);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.registerRating(dto);
			});
		}
	}

	@Test
	public void deleteRatingTest() {
		try {
			dto.setPatientId(223);
			boolean expectedFlag = dao.deleteRating(dto.getPatientId());
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.deleteRating(dto.getPatientId());
			});
		}
	}

	@Test
	public void updateRatingTest() {
		try {
			dto.setDoctorId(210);
			dto.setDoctorName("LKJ");
			dto.setPatientName("QWE");
			dto.setRating("Bad");
			boolean expectedFlag = dao.updateRating(dto);
			assertEquals(expectedFlag, false);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.getRating(dto.getPatientId());
			});
		}
	}

	@Test
	public void getAllRatingTest() {
		List<RatingDto> all = dao.getAllRating();
		assertNotNull(all);
	}

	@Test
	public void getRatingById() {
		dto.setPatientId(223);
		try {
			RatingDto dto1 = dao.getRating(dto.getPatientId());
			assertNotNull(dto1);
		} catch (Exception e) {
			assertThrows(ValidInputException.class, () -> {
				dao.getRating(dto.getPatientId());
			});

		}
	}
}
