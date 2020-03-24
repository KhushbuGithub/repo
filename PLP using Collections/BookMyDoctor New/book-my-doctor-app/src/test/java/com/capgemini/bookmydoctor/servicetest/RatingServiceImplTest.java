package com.capgemini.bookmydoctor.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.RatingDto;
import com.capgemini.bookmydoctor.exceptions.ValidInputException;
import com.capgemini.bookmydoctor.service.RatingService;
import com.capgemini.bookmydoctor.service.RatingServiceImpl;

class RatingServiceImplTest {

	private RatingDto dto = new RatingDto();
	private RatingService dao = new RatingServiceImpl();

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
			assertEquals(expectedFlag, true);
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
