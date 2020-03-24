package com.capgemini.bookmydoctor.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;

public class DoctorDaoImpl implements DoctorDao {

	private LinkedList<DoctorDetailsDto> doctorDto = MyDoctorDB.doctordetailsDto;

	@Override
	public boolean registerDoctor(DoctorDetailsDto doctor) {
		for (DoctorDetailsDto doctorInfoDto : doctorDto) {
			if ((doctorInfoDto.getDoctorId() == doctor.getDoctorId())
					|| (doctorInfoDto.getEmailId() == doctor.getEmailId())) {
				return false;
			}
		}
		MyDoctorDB.doctordetailsDto.add(doctor);
		return true;
	}

	@Override
	public boolean deleteDoctor(int doctorId) {
		DoctorDetailsDto dto = null;
		for (DoctorDetailsDto doctorInfoDto : doctorDto) {
			if (doctorInfoDto.getDoctorId() == doctorId) {
				dto = doctorInfoDto;
				MyDoctorDB.doctordetailsDto.remove(dto);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateDoctor(DoctorDetailsDto doctor) {
		for (DoctorDetailsDto doctorInfoDto : doctorDto) {
			if (doctorInfoDto.getDoctorId() == doctor.getDoctorId()) {
				doctorInfoDto.setDoctorName(doctor.getDoctorName());
				doctorInfoDto.setEmailId(doctor.getEmailId());
				doctorInfoDto.setPassword(doctor.getPassword());
				// doctorInfoDto.setYearOfExperience(doctor.getYearOfExperience());
				// doctorInfoDto.setCharges(doctor.getCharges());
				doctorInfoDto.setLocation(doctor.getLocation());
				doctorInfoDto.setContact(doctor.getContact());
				doctorInfoDto.setSpecialization(doctor.getSpecialization());
				doctorInfoDto.setAvailability(doctor.getAvailability());
				doctorInfoDto.setLeaveStatus(doctor.isLeaveStatus());
				return true;
			}
		}
		return false;
	}

	@Override
	public DoctorDetailsDto getDoctor(int doctorId) {
		DoctorDetailsDto dto = null;
		for (DoctorDetailsDto doctorInfoDto : doctorDto) {
			if (doctorInfoDto.getDoctorId() == doctorId) {
				dto = doctorInfoDto;
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<DoctorDetailsDto> getAllDoctor() {
		List<DoctorDetailsDto> doctorDtos = doctorDto;
		return doctorDtos;
	}

	@Override
	public List<DoctorDetailsDto> searchDoctor(String location) {

		List<DoctorDetailsDto> docInfo = new LinkedList<DoctorDetailsDto>();
		for (DoctorDetailsDto doctorInfo : doctorDto) {
			if (location.equals(doctorInfo.getLocation())) {
				docInfo.add(doctorInfo);
				return docInfo;
			}
		}
		return docInfo;
	}
}
