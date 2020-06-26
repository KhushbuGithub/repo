package com.capgemini.bookmydoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bookmydoctor.dao.PatientDAO;
import com.capgemini.bookmydoctor.dto.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientDAO dao;

	@Override
	public boolean addPatient(Patient patient) {
		return dao.addPatient(patient);
//		if(Validation.isId(patient.getPatientId())) {
//			if(Validation.isName(patient.getPatientName())) {
//				if(Validation.isName(patient.getGender())) {
//					if(Validation.isEmail(patient.getEmail())) {
//						if(Validation.isPassword(patient.getPassword())) {
//							BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//							String encodedPassword = encoder.encode(patient.getPassword());
//							patient.setPassword(encodedPassword);
//							if(Validation.isAge(patient.getAge())) {
//								if(Validation.isMob(patient.getMobileNumber())) {
//									if(Validation.isName(patient.getLocation())) {
//										if(Validation.isName(patient.getLanguage())) {
//											if(Validation.isName(patient.getTermsAndCondition())) {
//												return dao.addPatient(patient);
//											}else {
//												throw new PatientException("Terms And Condition should contain characters only");
//											}
//										}else {
//											throw new PatientException("Language should contain characters only");
//										}
//									}else {
//										throw new PatientException("Location should contain characters only");
//									}
//								}else {
//									throw new PatientException("Mobile number should contain 10-digit integer number");
//								}
//							}else {
//								throw new PatientException("Age should contain the integers from 0-200");
//							}
//						}else {
//							throw new PatientException("The password must contain one lowercase characters, one uppercase characters , one special symbols in the list \"@#$%\" and length at least 6 characters");
//						}
//					}else {
//						throw new PatientException("Email must contain one lowercase characters, one uppercase characters, Numbers from 0-9 , one special symbols in the list '-_.' and it should contain '@' followed by '.'");
//					}
//				}else {
//					throw new PatientException("Gender should contain characters only and minimum length is 4");
//				}
//			}else {
//				throw new PatientException("Patient name should contain only characters with minimum length 4");
//			}
//		}else {
//			throw new PatientException("The Id must contain numbers between 0-9 and minimum length 1");
//		}
	}

	@Override
	public Patient serarchPatient(int patientId) {
		return dao.serarchPatient(patientId);
	}

	@Override
	public List<Patient> getAllPatients() {
		return dao.getAllPatients();
	}

	@Override
	public boolean deletePatient(int patientId) {
		return dao.deletePatient(patientId);
	}

	@Override
	public boolean modifyPatient(Patient bean) {
		return dao.modifyPatient(bean);
//		if(Validation.isId(bean.getPatientId())) {
//			if(Validation.isName(bean.getPatientName())) {
//				if(Validation.isName(bean.getGender())) {
//					if(Validation.isEmail(bean.getEmail())) {
//						if(Validation.isPassword(bean.getPassword())) {
//							BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//							String encodedPassword = encoder.encode(bean.getPassword());
//							bean.setPassword(encodedPassword);
//							if(Validation.isAge(bean.getAge())) {
//								if(Validation.isMob(bean.getMobileNumber())) {
//									if(Validation.isName(bean.getLocation())) {
//										if(Validation.isName(bean.getLanguage())) {
//											if(Validation.isName(bean.getTermsAndCondition())) {
//												return dao.modifyPatient(bean);
//											}else {
//												throw new PatientException("Terms And Condition should contain characters only");
//											}
//										}else {
//											throw new PatientException("Language should contain characters only");
//										}
//									}else {
//										throw new PatientException("Location should contain characters only");
//									}
//								}else {
//									throw new PatientException("Mobile number should contain 10-digit integer number");
//								}
//							}else {
//								throw new PatientException("Age should contain the integers from 0-200");
//							}
//						}else {
//							throw new PatientException("The password must contain one lowercase characters, one uppercase characters , one special symbols in the list \"@#$%\" and length at least 6 characters");
//						}
//					}else {
//						throw new PatientException("Email must contain one lowercase characters, one uppercase characters, Numbers from 0-9 , one special symbols in the list '-_.' and it should contain '@' followed by '.'");
//					}
//				}else {
//					throw new PatientException("Gender should contain characters only and minimum length is 4");
//				}
//			}else {
//				throw new PatientException("Patient name should contain only characters with minimum length 4");
//			}
//		}else {
//			throw new PatientException("The Id must contain numbers between 0-9 and minimum length 1");
//		}
//	}

}
}
