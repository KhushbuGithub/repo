package com.capgemini.bookmydoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.DoctorAvailablityDAO;
import com.capgemini.bookmydoctor.dto.DoctorAvailablity;
import com.capgemini.bookmydoctor.validation.Validation;

@Service
public class DoctorAvailablityServiceImpl implements DoctorAvailablityService {
	
	@Autowired
	DoctorAvailablityDAO dao;

	@Override
	public boolean addDoctorAvailability(DoctorAvailablity bean) {
		return dao.addDoctorAvailability(bean);
//		if(Validation.isId(bean.getAvailabilityId())) {
//			if(Validation.isId(bean.getDoctorId())) {
//				if(Validation.isDate(bean.getFromDate())) {
//					if(Validation.isDate(bean.getToDate())) {
//						return dao.addDoctorAvailability(bean);
//					}else {
//						return dao.
//					}
//				}
//			}
//		}
	}

	@Override
	public boolean deleteDoctorAvailability(int availabilityId) {
		return dao.deleteDoctorAvailability(availabilityId);
	}

	@Override
	public List<DoctorAvailablity> getAllDoctorAvailabilities() {
		return dao.getAllDoctorAvailabilities();
	}

	@Override
	public DoctorAvailablity searchDoctorAvailability(int availabilityId) {
		return dao.searchDoctorAvailability(availabilityId);
	}

	@Override
	public boolean modifyDoctorAvailability(DoctorAvailablity bean) {
		return dao.modifyDoctorAvailability(bean);
	}

}
