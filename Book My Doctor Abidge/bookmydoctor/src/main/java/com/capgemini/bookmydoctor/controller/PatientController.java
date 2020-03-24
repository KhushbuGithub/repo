package com.capgemini.bookmydoctor.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.dao.PatientDao;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.HospitalDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.PaymentDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.exception.InvalidLoginException;
import com.capgemini.bookmydoctor.factory.Factory;
import com.capgemini.bookmydoctor.service.PatientService;
import com.capgemini.bookmydoctor.service.UserService;

public class PatientController {
	PatientService serv = Factory.getPatientServ();
	PatientRegisterDto dto = Factory.getPatientRegisterDto();

	UserService userServ = Factory.getUserServ();
	UserDto userDto = Factory.getUserDto();

	Scanner sc = new Scanner(System.in);
	Logger log = LogManager.getLogger(Main.class);

	public void enterOptions() {
		log.info(".................................");
		log.info("press 2 for registration if you are a new user");
		log.info("..................................");
		log.info("press 1 for Login ");
		int option = sc.nextInt();
		if (option == 1) {
			login();
		} else if (option == 2) {

		}
	}

	private void login() throws InvalidLoginException{

		log.info("enter userId");
		int userId = sc.nextInt();
		userDto.setUserId(userId);
		log.info(userId);

		log.info("enter password");
		String password = sc.next();
		userDto.setPassword(password);
		log.info(password);
		
		
		log.info("enter userType");
		String userType = sc.next();
		
		if(userDto.getUserType().equals("patient")) {
		if ((userDto.getUserId() == userId) && (userDto.getPassword().equals(password))) {
   
			log.info("logged in successfully");

			int choice = 0;
			log.info("1. enter your discription");
			log.info("2. choose hospital");
			log.info("3. search doctor");
			log.info("4. select doctor");
			log.info("5. make payment");
			log.info("6. manage appointment");
			log.info("7. Exit");
			log.info("\n");

			do {
				log.info("......................");
				log.info("select the options");
				log.info("......................");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					patientDiscription();
					break;
				case 2:
					chooseHospital();

					break;
				case 3:

					searchDoctor();
					break;
				case 4:

					selectDoctor();
					break;
				case 5:

					makePayment();
					break;
				case 6:
					manageAppointment();

					break;

				default:
					log.info("invalid input");
					break;
				}

			} while (choice != 7);

		}
		}	else {
			//throw new InvalidLoginException("enter proper credentials");
		}
	}

	private void patientDiscription() {
		log.info("enter the information");
		log.info("enter patientId");
		int patientId = sc.nextInt();
		dto.setPatientId(patientId);

		log.info("enter first name");
		String firstName = sc.next();
		dto.setFirstName(firstName);

		log.info("enter last name");
		String lastName = sc.next();
		dto.setLastName(lastName);

		log.info("enter phone Number");
		long phoneNumber = sc.nextLong();
		dto.setPhoneNumber(phoneNumber);

		log.info("enter emailId");
		String emailId = sc.next();
		dto.setEmailId(emailId);

		log.info("enter date of birth");
		String dob1 = sc.next();
		Date DOB = Date.valueOf(dob1);
		dto.setDob(DOB);

		log.info("enter age");
		int age = sc.nextInt();
		dto.setAge(age);

		log.info("enter gender");
		String gender = sc.next();
		dto.setGender(gender);

		log.info("enter date Of Registration");
		String d1 = sc.next();
		Date dateOfRegistration = Date.valueOf(d1);
		dto.setDateOfRegistration(dateOfRegistration);

		log.info("enter address");
		String address = sc.next();
		dto.setAddress(address);

		log.info("enter pincode");
		int pincode = sc.nextInt();
		dto.setPincode(pincode);

		log.info("enter problem");
		String problem = sc.next();
		dto.setProblem(problem);

		serv.patientDiscription(dto);
		log.info("successfully registered");

	}

	private List<HospitalDetailsDto> chooseHospital() {
		HospitalDetailsDto hdto = Factory.getHospDto();
		PatientDao dao = Factory.getPatientDao();

		log.info("enter the information");
		log.info("enter hospitalId");
		int hospitalId = sc.nextInt();
		hdto.setHospitalId(hospitalId);

		log.info("enter hospital rating");
		int rating = sc.nextInt();
		hdto.setRating(rating);

		List<HospitalDetailsDto> info = dao.chooseHospital(rating, hospitalId);
		log.info("hospital information");
		for (HospitalDetailsDto h : info) {

			log.info("hospital id is: " + h.getHospitalId());
			log.info("hospital name is: " + h.getHospitalName());
			log.info("hospital addre" + "ss is: " + h.getAddress());
			log.info("hospital office email-id is: " + h.getEmail());
			log.info("hospital office mobile no is: " + h.getMobno());
			log.info("hospital rating is: " + h.getRating());
			log.info("*****************************");
		}
		return info;

	}

	private List<DoctorDetailsDto> searchDoctor() {
		DoctorDetailsDto dto = Factory.getDoctorDetailsDto();
		PatientDao dao = Factory.getPatientDao();
		log.info("enter specialisation of doctor");
		String specialization = sc.next();
		dto.setSpecialization(specialization);

		log.info("doctor infomation");
		List<DoctorDetailsDto> info1 = dao.searchDoctor(specialization);
		for (DoctorDetailsDto d : info1) {
			log.info("doctor id is: " + d.getDoctorId());
			log.info("doctor name is: " + d.getDoctorName());
			log.info("doctor specialization " + d.getSpecialization());
			log.info("doctor experience is: " + d.getYearOfExperience());
			log.info("doctor is available from : " + d.getAvailabilityFromDay());
			log.info("To this day : " + d.getAvailabilityEndDay());
			log.info("doctor is available from: " + d.getAvailabilityStartTime());
			log.info("To this time : " + d.getAvailabilityEndTime());
			log.info("carges : " + d.getCharges());
			log.info("rating of a doctor: " + d.getRating());

			log.info("*****************************");
		}
		return info1;

	}

	private List<DoctorDetailsDto> selectDoctor() {
		DoctorDetailsDto dto = Factory.getDoctorDetailsDto();
		PatientDao dao = Factory.getPatientDao();

		log.info("enter details of doctor you want to choose");
		log.info("enter doctor Id");
		int doctorId = sc.nextInt();
		dto.setDoctorId(doctorId);

		log.info("enter doctor Name");
		String doctorName = sc.next();
		dto.setDoctorName(doctorName);

		log.info("enetr specialisation");
		String specialization = sc.next();
		dto.setSpecialization(specialization);

		log.info("selected doctor infomation ");
		List<DoctorDetailsDto> info2 = dao.searchDoctor(specialization);
		for (DoctorDetailsDto d : info2) {
			log.info("doctor id is: " + d.getDoctorId());
			log.info("doctor name is: " + d.getDoctorName());
			log.info("doctor specialization " + d.getSpecialization());
			log.info("doctor experience is: " + d.getYearOfExperience());
			log.info("doctor is available from : " + d.getAvailabilityFromDay());
			log.info("To this day : " + d.getAvailabilityEndDay());
			log.info("doctor is available from: " + d.getAvailabilityStartTime());
			log.info("To this time : " + d.getAvailabilityEndTime());
			log.info("carges : " + d.getCharges());
			log.info("rating of a doctor: " + d.getRating());

			log.info("*****************************");
		}
		return info2;

	}

	private void makePayment() {
		PaymentDto dto = Factory.getPaymentDto();
		log.info("make payment now");
		log.info("enter patient id");
		int patientId = sc.nextInt();
		dto.setPatientId(patientId);

		log.info("enter payment type");
		String paymentType = sc.next();
		dto.setPaymentType(paymentType);

		log.info("enetr payment Date");
		String date = sc.next();
		Date paymentDate = Date.valueOf(date);
		dto.setPaymentDate(paymentDate);

		log.info("enter amount");
		int amount = sc.nextInt();
		dto.setAmount(amount);

		serv.makePayment(patientId, paymentType, paymentDate, amount);
		log.info("Appointment is confirmed with specified date");

	}

	private void manageAppointment() {
		PaymentDto dto = Factory.getPaymentDto();
		log.info("for managing the appointment enter patient id");
		log.info("enter patient id");
		int patientId = sc.nextInt();
		dto.setPatientId(patientId);

		serv.manageAppointment(patientId);
		log.info("appintment is managed");

	}

}
