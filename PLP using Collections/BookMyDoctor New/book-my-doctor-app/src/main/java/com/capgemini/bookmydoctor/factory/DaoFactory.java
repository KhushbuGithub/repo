package com.capgemini.bookmydoctor.factory;

import com.capgemini.bookmydoctor.dao.AdminDao;
import com.capgemini.bookmydoctor.dao.AdminDaoImpl;
import com.capgemini.bookmydoctor.dao.AppointmentDao;
import com.capgemini.bookmydoctor.dao.AppointmentDaoImpl;
import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dao.DoctorDaoImpl;
import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dao.PatientDaoImpl;
import com.capgemini.bookmydoctor.dao.RatingDao;
import com.capgemini.bookmydoctor.dao.RatingDaoImpl;

public class DaoFactory {

	public static PatientDao getPatientDao() {
		return new PatientDaoImpl();
	}

	public static DoctorDao getDoctorDao() {
		return new DoctorDaoImpl();
	}

	public static AppointmentDao getAppointmentDao() {
		return new AppointmentDaoImpl();
	}

	public static RatingDao getRatingDao() {
		return new RatingDaoImpl();
	}

	public static AdminDao getAdminDao() {
		return new AdminDaoImpl();
	}

}
