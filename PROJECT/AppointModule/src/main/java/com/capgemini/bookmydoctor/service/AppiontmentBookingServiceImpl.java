package com.capgemini.bookmydoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.AppiontmentBookingDAO;
import com.capgemini.bookmydoctor.dao.PatientDAO;
import com.capgemini.bookmydoctor.dto.AppiontmentBooking;
import com.capgemini.bookmydoctor.exception.AppiontmentBookingException;
import com.capgemini.bookmydoctor.exception.PatientException;
import com.capgemini.bookmydoctor.validation.Validation;

@Service
public class AppiontmentBookingServiceImpl implements AppiontmentBookingService {

	@Autowired
	AppiontmentBookingDAO dao;

	@Autowired
	PatientDAO patientDao;

	@Override
	public boolean addAppiontment(AppiontmentBooking appiontment) {
		// return dao.addAppiontment(appiontment);
		if (Validation.isId(appiontment.getAppiontmentId())) {
			if (Validation.isName(appiontment.getPatientName())) {
				if (Validation.isAge(appiontment.getAge())) {
					if (Validation.isName(appiontment.getDiseaseSymptoms())) {
						if (Validation.isName(appiontment.getApproval())) {
							if (Validation.isId(appiontment.getPatient().getUserId())) {
								if (patientDao.serarchPatient(appiontment.getPatient().getUserId()) == null) {
									throw new PatientException("Id  does not found");
								} else {
									return dao.addAppiontment(appiontment);
								}
							} else {
								throw new AppiontmentBookingException(
										"PatientId must contain the numbers from 0-9 and minimum length of 1");
							}
						} else {
							throw new AppiontmentBookingException("Approval should contain characters only");
						}
					} else {
						throw new AppiontmentBookingException("Disease Symptoms should contain atleast 4 characters");
					}
				} else {
					throw new AppiontmentBookingException("Age should contain integers from 0 to 200");
				}
			} else {
				throw new AppiontmentBookingException("Patient Name should contain atleast 4 characters");
			}
		} else {
			throw new AppiontmentBookingException(
					"AppiontmentId must contain the numbers from 0-9 and minimum length of 1");
		}
	}

	@Override
	public AppiontmentBooking serarchAppiontment(int appiontmentId) {
		return dao.searchAppiontment(appiontmentId);
	}

	@Override
	public List<AppiontmentBooking> getAllAppiontments() {
		return dao.getAllAppiontments();
	}

	@Override
	public boolean deleteAppiontment(int appiontmentId) {
		return dao.deleteAppiontment(appiontmentId);
	}

	@Override
	public boolean modifyAppiontment(AppiontmentBooking bean) {
		// return dao.modifyAppiontment(bean);
		if (Validation.isId(bean.getAppiontmentId())) {
			if (Validation.isName(bean.getPatientName())) {
				if (Validation.isAge(bean.getAge())) {
					if (Validation.isName(bean.getDiseaseSymptoms())) {
						if (Validation.isName(bean.getApproval())) {
							if (Validation.isId(bean.getPatient().getUserId())) {
								return dao.modifyAppiontment(bean);
							} else {
								throw new AppiontmentBookingException(
										"PatientId must contain the numbers from 0-9 and minimum length of 1");
							}
						} else {
							throw new AppiontmentBookingException(
									"Approval should contain characters with minimum length 4");
						}
					} else {
						throw new AppiontmentBookingException("Disease Symptoms should contain atleast 4 characters");
					}
				} else {
					throw new AppiontmentBookingException("Age should contain integers from 0 to 200");
				}
			} else {
				throw new AppiontmentBookingException("Patient Name should contain atleast 4 characters");
			}
		} else {
			throw new AppiontmentBookingException(
					"AppiontmentId must contain the numbers from 0-9 and minimum length of 1");
		}

	}

	@Override
	public List<AppiontmentBooking> getAppiontments(int patientId) {
		return dao.getAppiontments(patientId);
	}

	@Override
	public List<AppiontmentBooking> getAppiontmentsByName(String doctorName) {
		return dao.getAppiontmentsByName(doctorName);
	}
}
