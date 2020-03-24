package com.capgemini.bookmydoctor.controller;

import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.dao.DoctorDao;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.PaymentDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.factory.Factory;
import com.capgemini.bookmydoctor.factory.UserFactory;
import com.capgemini.bookmydoctor.service.DoctorService;
import com.capgemini.bookmydoctor.service.DoctorServiceImpl;
import com.capgemini.bookmydoctor.service.UserService;

public class DoctorController {
	DoctorService serv = Factory.getDoctorService();
	DoctorDetailsDto dto = Factory.getDoctorDetailsDto();
	UserService userServ = Factory.getUserServ();
	UserDto userDto = Factory.getUserDto();
	Scanner sc = new Scanner(System.in);
	Logger log = LogManager.getLogger(PatientController.class);

	public void enterOptions() {
		log.info("________________________________________________");
		log.info("press 1 for Login ");
		log.info("________________________________________________");
		log.info("press 2 for registration if you are a new user");
		int option = sc.nextInt();
		if (option == 1) {
			login();
		} else if (option == 2) {
			UserController userController = new UserController();
			userController.userRegister();
		}
	}

	private void login() {
		log.info("enter UserId");
		int userId = sc.nextInt();
		userDto.setUserId(userId);

		log.info("enter password");
		String password = sc.next();
		userDto.setPassword(password);
		log.info("Enter UserType");
		String userType = sc.next();
		userDto.setUserType(userType);

		if (userDto.getPassword().equalsIgnoreCase(password)) {
			if (userDto.getUserType().equalsIgnoreCase("doctor")) {

				log.info(" Login successful ");

				int choice = 0;
				log.info("1. Enter your description");
				log.info("2. To View Appointment");
				log.info("3. Patient History");

				log.info("4. Manage Availability");
				log.info("5. View Payment Details");
				log.info("6. View Feedback ");
				log.info("7. Exit");
				log.info("\n");

				do {
					log.info("____________________________________________");
					log.info("select the options");
					log.info("____________________________________________");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						doctorDescription();
						break;
					case 2:
						viewAppointment();

						break;
					case 3:

						searchPatientHistory();
						break;
					case 4:

						manageAvailability();
						break;
					case 5:
						viewPaymentDetails();

						break;
					case 6:
						viewFeedback();

						break;

					default:
						log.info("Invalid input");
						break;
					}

				} while (choice != 7);

			} else {
				enterOptions();
			}
		} else
			log.info("password and userId is not valid");

	}

	private List<AppointmentDto> viewAppointment() {
		AppointmentDto adto = Factory.getAppointmetDto();
		DoctorDao dao = Factory.getDoctorDao();
		log.info("Enter Doctor Id");
		int doctorId = sc.nextInt();
		adto.setDoctorId(doctorId);
		List<AppointmentDto> info = dao.viewAppointment(doctorId);
		log.info("Appointment");
		for (AppointmentDto appointmentDto : info) {
			log.info("_______________________________");
			log.info("Doctor id is " + appointmentDto.getDoctorId());
			log.info("Number of in patients " + appointmentDto.getNumberOfInPatients());
			log.info("Number of out patients " + appointmentDto.getNumberOfOutPatients());
			log.info("Appointment Time " + appointmentDto.getAppointmentTime());
			log.info("_______________________________");
		}
		return info;
	}

	private List<PatientRegisterDto> searchPatientHistory() {
		PatientRegisterDto hdto = Factory.getPatientRegisterDto();
		DoctorDao dao = Factory.getDoctorDao();

		log.info("enter the information");
		log.info("enter patientId");
		int patientId = sc.nextInt();
		hdto.setPatientId(patientId);

		List<PatientRegisterDto> info = dao.searchPatientHistory(patientId);
		log.info("Patient History");
		for (PatientRegisterDto h : info) {
			log.info("hospital id is: " + h.getDateOfRegistration());
			log.info("hospital name is: " + h.getProblem());

			log.info("*****************************");
		}
		return info;

	}

	private List<PaymentDto> viewPaymentDetails() {
		PaymentDto pdto = Factory.getPaymentDto();
		DoctorDao dao = Factory.getDoctorDao();
		log.info("Enter Patient Id");
		int patientId = sc.nextInt();
		pdto.setPatientId(patientId);
		List<PaymentDto> info = dao.viewPaymentDetails(patientId);
		log.info("Payment Details");
		for (PaymentDto paymentDto : info) {

			log.info("Payment Type" + paymentDto.getPaymentType());
			log.info("Payment Date" + paymentDto.getPaymentDate());
			log.info("Amouny" + paymentDto.getAmount());
		}

		return info;
	}

	private List<HospitalDetailsDto> viewFeedback() {

		HospitalDetailsDto hdto = Factory.getHospDto();
		DoctorDao dao = Factory.getDoctorDao();

		log.info("enter the information");
		log.info("enter hospitalName");
		String hospitalName = sc.next();
		hdto.setHospitalName(hospitalName);

		List<HospitalDetailsDto> info = dao.viewFeedback(hospitalName);
		log.info("hospital information");
		for (HospitalDetailsDto h : info) {
			log.info("hospital id is: " + h.getHospitalId());
			log.info("hospital name is: " + h.getHospitalName());
			log.info("hospital rating is: " + h.getRating());
			log.info("*****************************");
		}
		return info;

	}

	private void manageAvailability() {

		log.info("Manage Availability");
		log.info("Enter Doctor Id");
		int doctorId = sc.nextInt();
		dto.setDoctorId(doctorId);

		log.info("Enter Availability Day");
		String availabilityFromDay = sc.next();
		dto.setAvailabilityFromDay(availabilityFromDay);

		log.info("Enter Availability End Day");
		String availabilityEndDay = sc.next();
		dto.setAvailabilityEndDay(availabilityEndDay);

		log.info("Enter Availability Start Time");
		String t = sc.next();
		Time availabilityStartTime = Time.valueOf(t);
		dto.setAvailabilityStartTime(availabilityStartTime);

		log.info("Enter Availability End Time");
		String t1 = sc.next();
		Time availabilityEndTime = Time.valueOf(t1);
		dto.setAvailabilityEndTime(availabilityEndTime);

		log.info("Enter Charges");
		int charges = sc.nextInt();
		dto.setCharges(charges);

		serv.manageAvailability(doctorId, availabilityFromDay, availabilityEndDay, availabilityStartTime,
				availabilityEndTime, charges);

		log.info("schedule of doctor is managed successfully");
	}

	private void doctorDescription() {
		log.info("enter the information");
		log.info("enter doctorId");
		int doctorId = sc.nextInt();
		dto.setDoctorId(doctorId);

		log.info("Enter Doctor Name");
		String doctorName = sc.next();
		dto.setDoctorName(doctorName);

		log.info("Specialization In");
		String specialization = sc.next();
		dto.setSpecialization(specialization);

		log.info("Year of Expereince");
		int yearOfExperience = sc.nextInt();
		dto.setYearOfExperience(yearOfExperience);

		log.info("Enter Availability From Day");

		String availabilityFromDay = sc.next();
		dto.setAvailabilityFromDay(availabilityFromDay);
		;

		log.info("Enter Availability End Day");
		String availabilityEndDay = sc.next();

		dto.setAvailabilityEndDay(availabilityEndDay);

		log.info("Enter Availability Start Time");
		String time = sc.next();
		Time availabilityStartTime = Time.valueOf(time);
		dto.setAvailabilityStartTime(availabilityStartTime);

		log.info("Enter Availability End Time");
		String time1 = sc.next();
		Time availabilityEndTime = Time.valueOf(time1);
		dto.setAvailabilityEndTime(availabilityEndTime);

		log.info("Enter Charges");
		int charges = sc.nextInt();
		dto.setCharges(charges);

		serv.doctorDescription(dto);

	}

}
