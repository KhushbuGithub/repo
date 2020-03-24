package com.capgemini.bookmydoctor.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.dao.AdminDao;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegisterDto;
import com.capgemini.bookmydoctor.dto.UserDto;
import com.capgemini.bookmydoctor.exception.AdminException;
import com.capgemini.bookmydoctor.factory.Factory;
import com.capgemini.bookmydoctor.factory.UserFactory;
import com.capgemini.bookmydoctor.service.AdminService;
import com.capgemini.bookmydoctor.service.UserService;

public class AdminController {

	AdminDto adminDto = Factory.getAdminDto();
	AdminService adminService = Factory.getAdminService();
	UserDto userDto = UserFactory.getUserDto();
	AppointmentDto appointdto = Factory.getAppointmetDto();
	UserService userService = UserFactory.getUserService();
	PatientRegisterDto patientDto = Factory.getPatientRegisterDto();
	DoctorDetailsDto doctorDto = Factory.getDoctorDetailsDto();
	
	Logger log = LogManager.getLogger("admin");
	Scanner sc = new Scanner(System.in);

	
	
	public void enterOptions() {
		log.info("Choose the options");
		log.info("Press 1 for login");
		log.info("Press 2 to register");
		int option = sc.nextInt();
		if(option == 1) {
			adminLogin();
		} else if (option == 2) {
			log.info("Register");
			adminRegister();
		}
	}
	public void adminRegister() {
		log.info("Enter adminId");
		int adminId=sc.nextInt();
		adminDto.setAdminId(adminId);
		
		log.info("Enter userId");
		int userId = sc.nextInt();
		adminDto.setUserId(userId);
		
		log.info("Enter adminName");
		String adminName = sc.next();
		adminDto.setAdminName(adminName);
		
		log.info("Enter password");
		String password = sc.next();
		adminDto.setPassword(password);
		
		adminService.registerAdmin(adminDto);
		
		log.info("admin registered");
	}
	public void adminLogin() {
		log.info("Please login");
		log.info(" Enter user id ");
		int userId=sc.nextInt();
		userDto.setUserId(userId);
		
		log.info(" Enter Password ");
		String password = sc.next();
		userDto.setPassword(password);

		if (userDto.getUserId() == userId && userDto.getPassword().equalsIgnoreCase(password)) {
			log.info("login successfull");
        
			int choice = 0;
			log.info("Choose Admin operations");
			log.info("1. Add doctor");
			log.info("2. Delete Doctor");
			log.info("3. Delete Patient");
			log.info("4. View appointments");
			log.info("5. View doctor info");
			log.info("6. Update appointment");
			log.info("7. Delete admin");
			log.info("\n");


			do {
				log.info("......................");
				log.info("select the options");
				log.info("......................");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					addDoctor();
					break;
				case 2:
					deleteDoctor();
					break;

				case 3:
					deletePatient();

					break;
				case 4:

					viewAppointments();
					break;
				case 5:

					viewDoctorInfo();
					break;
				case 6:
					updateAppointment();
					break;
				case 7:

					deleteAdmin();
					break;

				default:
					log.info("invalid input");
					break;
				}

			} while (choice != 8);

		}
		}
	

	public void addDoctor() {
	
		log.info("adding Doctor");
		log.info("Enter doctorId");
		int doctorId = sc.nextInt();
		doctorDto.setDoctorId(doctorId);
		
		log.info("Enter doctorName");
		String doctorName = sc.next();
		doctorDto.setDoctorName(doctorName);
		
		log.info("Enter specialization");
		String specialization = sc.next();
		doctorDto.setSpecialization(specialization);
		
		log.info("Enter yearOfExperience");
		int yearOfExperience = sc.nextInt();
		doctorDto.setYearOfExperience(yearOfExperience);
		
		log.info("Enter availabilityFromDay");
		String availabilityFromDay = sc.next();
		doctorDto.setAvailabilityFromDay(availabilityFromDay);
		
		log.info("Enter availabilityEndDay");
		String availabilityEndDay = sc.next();
		doctorDto.setAvailabilityEndDay(availabilityEndDay);
		
		log.info("Enter availabilityStartTime");
		String t1 = sc.next();
		Time availabilityStartTime = Time.valueOf(t1);
		doctorDto.setAvailabilityStartTime(availabilityStartTime);
		
		log.info("Enter availabilityEndTime");
		String t2 = sc.next();
		Time availabilityEndTime = Time.valueOf(t2);
		doctorDto.setAvailabilityEndTime(availabilityEndTime);
		
		log.info("Enter charges");
		int charges = sc.nextInt();
		doctorDto.setCharges(charges);
		
		log.info("Enter ratings");
		int rating = sc.nextInt();
		doctorDto.setRating(rating);
		
		adminService.addDoctor(doctorDto);
		log.info("User is added");
	}
	
	public void deleteDoctor() {
		log.info("Enter doctorId");
		int doctorId = sc.nextInt();
		doctorDto.setDoctorId(doctorId);
		
		adminService.deleteDoctor(doctorId);
		log.info("Doctor is deleted");
	}
	

	public void deletePatient() {
         log.info("delete patient");
         log.info("Enter patientId");
         int patientId = sc.nextInt();
         patientDto.setPatientId(patientId);
         
         adminService.deletePatient(patientId);
         log.info("patient is deleted");
	}
	
	public List<AppointmentDto> viewAppointments() {
		AdminDao adminDao = Factory.getAdminDao();
		log.info("Enter appointmentId");
		int appointmentId = sc.nextInt();
		appointdto.setAppointmentId(appointmentId);
		
		
		List<AppointmentDto> info = adminDao.viewAppointment(appointmentId);
		for (AppointmentDto appointmentDto : info) {
			log.info("____________________________");
			log.info("Doctor id is " + appointmentDto.getDoctorId());
			log.info("Number of in patients " + appointmentDto.getNumberOfInPatients());
			log.info("Number of out patients " + appointmentDto.getNumberOfOutPatients());
			log.info("Appointment Date of patient " + appointmentDto.getAppointmentDate());
			log.info("Appointment Time " + appointmentDto.getAppointmentTime());
			log.info("_______________________________");
		}
		
		return info;
	}
	
	public List<DoctorDetailsDto> viewDoctorInfo() {
		AdminDao adminDao = Factory.getAdminDao();
	
		log.info("Enter doctorId");
		int doctorId = sc.nextInt();
		doctorDto.setDoctorId(doctorId);
		
        List<DoctorDetailsDto> list = adminDao.viewDoctor(doctorId);
        for (DoctorDetailsDto doctorDetailsDto : list) {
        	log.info("___________________________________________________");
			log.info("Doctor Name is " + doctorDetailsDto.getDoctorName());
			log.info("Specialization of Doctor is " + doctorDetailsDto.getSpecialization());
			log.info("Years of experience " + doctorDetailsDto.getYearOfExperience());
			log.info("Availabile from " + doctorDetailsDto.getAvailabilityFromDay());
			log.info("Available till " + doctorDetailsDto.getAvailabilityEndDay());
			log.info("Arriving Time " + doctorDetailsDto.getAvailabilityStartTime());
			log.info("Leaving Time " + doctorDetailsDto.getAvailabilityEndTime());
			log.info("Charges per patient " + doctorDetailsDto.getCharges());
			log.info("Ratings of Doctor " + doctorDetailsDto.getRating());
			log.info("___________________________________________________");
		}
       
		return list;
	}
	
	public void updateAppointment() {
		log.info("Enter appointmentId");
		int appointmentId = sc.nextInt();
		doctorDto.setDoctorId(appointmentId);
		
		log.info("Enter appointmentDate");
		String d1 = sc.next();
		Date appointmentDate = Date.valueOf(d1);
		appointdto.setAppointmentDate(appointmentDate);
		
		log.info("Enter appointmentTime");
		String t3 = sc.next();
		Time appointmentTime = Time.valueOf(t3);
		appointdto.setAppointmentTime(appointmentTime);
		
		adminService.updateAppointment(appointmentDate, appointmentTime, appointmentId);
		
		log.info("updated");
	}
	
	public void deleteAdmin() {
		log.info("Enter adminId");
		int adminId = sc.nextInt();
		adminService.deleteAdmin(adminId);
	}
}
