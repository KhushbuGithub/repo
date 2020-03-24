package com.capgemini.bookmydoctor.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;
import com.capgemini.bookmydoctor.dto.RatingDto;
import com.capgemini.bookmydoctor.service.AppointmentService;
import com.capgemini.bookmydoctor.service.AppointmentServiceImpl;
import com.capgemini.bookmydoctor.service.DoctorService;
import com.capgemini.bookmydoctor.service.DoctorServiceImpl;
import com.capgemini.bookmydoctor.service.PatientService;
import com.capgemini.bookmydoctor.service.PatientServiceImpl;
import com.capgemini.bookmydoctor.service.RatingService;
import com.capgemini.bookmydoctor.service.RatingServiceImpl;
import com.capgemini.bookmydoctor.validations.Validations;

public class PatientController {

	static Logger log = Logger.getLogger(PatientController.class);

	private LinkedList<PatientRegistrationDto> patientdto = MyDoctorDB.patientregistrationDto;
	private AppointmentService appointmentService = new AppointmentServiceImpl();
	private LinkedList<DoctorDetailsDto> doctordto = MyDoctorDB.doctordetailsDto;
	AppointmentService service = new AppointmentServiceImpl();

	static int patientId = 0;
	static String patientName = null;

	public boolean login() {
		int count = 0;
		while (true) {
			log.info("Enter email(Ex-sai@gmail.com)");
			String ch = null;
			char c = 'y';
			while (c == 'y') {
				ch = sc.next();
				if (Validations.isEmail(ch)) {
					c = 'n';
				} else {
					log.info("Enter correct email pattern");
				}
			}
			String email = ch;
			log.info("Enter password(Atleast min 8 max 16,One Integer,One Capsletter,One Specialsymbol(Ex-Querty@1A))");
			String ch1 = null;
			char c1 = 'y';
			while (c1 == 'y') {
				ch1 = sc.next();
				if (Validations.isPassword(ch1)) {
					c1 = 'n';
				} else {
					log.info("Enter correct password pattern");
				}
			}
			String password = ch1;
			for (PatientRegistrationDto patientInfoDto : patientdto) {
				if (email.equals(patientInfoDto.getEmailId()) && (password.equals(patientInfoDto.getPassword()))) {
					PatientController.patientId = patientInfoDto.getPatientId();
					PatientController.patientName = patientInfoDto.getPatientName();
					log.info("Login Successful!!! Welcome to Patient page ");
					return true;
				}
			}
			log.info("Invalid Credentials!!!");
			count++;
			if (count == 5) {
				break;
			}
		}
		return false;

	}

	Scanner sc = new Scanner(System.in);

	public void register() {
		PatientService service = new PatientServiceImpl();
		PatientRegistrationDto dto = new PatientRegistrationDto();
		while (true) {
			log.info("Enter Patient ID");
			String patientId = sc.next();
			int patID = Main.numValidate(patientId);
			if (patID == 0) {
				log.info("Invalid Patient ID");
			} else {
				dto.setPatientId(patID);
				break;
			}
		}

		log.info("Enter patient Name");
		String usrName = sc.next();
		while (!Validations.isStringAlphabet(usrName)) {
			log.info("Enter valid name");
			log.info("Enter Patient Name");
			usrName = sc.next();
			dto.setPatientName(usrName);
		}
		dto.setPatientName(usrName);

		log.info("Enter Email:(Ex-sai@gmail.com)");
		String ch = null;
		char c = 'y';
		while (c == 'y') {
			ch = sc.next();
			if (Validations.isEmail(ch)) {
				c = 'n';
			} else {
				log.info("Enter correct email pattern");
			}
		}
		dto.setEmailId(ch);
		log.info("Enter Password(Atleast min 8 max 16,One Integer,One Capsletter,One Specialsymbol(Ex-Querty@1A))");
		String ch1 = null;
		char c1 = 'y';
		while (c1 == 'y') {
			ch1 = sc.next();
			if (Validations.isPassword(ch1)) {
				c1 = 'n';
			} else {
				log.info("Enter correct password pattern");
			}
		}
		dto.setPassword(ch1);
		log.info("Enter your Gender:");
		String usrName1 = sc.next();
		while (!Validations.isStringAlphabet(usrName1)) {
			log.info("Enter  only alphabets");
			log.info("Enter your Gender");
			usrName1 = sc.next();
			dto.setGender(usrName1);
		}
		dto.setGender(usrName1);
		// dto.setGender(sc.next());
		log.info("Enter Address");
		String usrName2 = sc.next();
		while (!Validations.isStringAlphabet(usrName2)) {
			log.info("Enter  only alphabets");
			log.info("Enter Address");
			usrName2 = sc.next();
			dto.setAddress(usrName2);
		}
		dto.setAddress(usrName2);
		while (true) {
			log.info("Enter Your Age");
			String patientAge = sc.next();
			int patAGE = Main.numValidate(patientAge);
			if (patAGE == 0) {
				log.info("Invalid Age");
			} else {
				dto.setAge(patAGE);
				break;
			}
		}
		while (true) {
			log.info("Enter your Contact number");
			String patientNum = sc.next();
			long patNum = Main.phoneNumberValidate(patientNum);
			if (patNum == 0) {
				log.info("Invalid Number");
			} else {
				dto.setPhoneNumber(patNum);
				;
				break;
			}
		}

		for (PatientRegistrationDto patientInfo : patientdto) {
			if (!(dto.getEmailId().equals(patientInfo.getEmailId())
					&& (patientInfo.getPatientId() == dto.getPatientId()))) {
				if (service.registerPatient(dto)) {
					log.info("Patient registered successfully...");
				} else {
					log.info("Registration Failed!! ID already Exist  !!!");

				}
			} else if (dto.getEmailId().equals(patientInfo.getEmailId())) {
				log.info("Registration Failed!!!Email already exist!!!");
			} else {
				log.info("Duplicate Id!!!");
			}
			break;
		}

	}

	public void update() {
		PatientService service = new PatientServiceImpl();
		PatientRegistrationDto dto = new PatientRegistrationDto();

		dto.setPatientId(patientId);
		dto.setPatientName(patientName);

		log.info("Enter Email:(Ex-sai@gmail.com)");
		String ch = null;
		char c = 'y';
		while (c == 'y') {
			ch = sc.next();
			if (Validations.isEmail(ch)) {
				c = 'n';
			} else {
				log.info("Enter correct email pattern");
			}
		}
		dto.setEmailId(ch);
		log.info("Enter Password (Atleast min 8 max 16,One Integer,One Capsletter,One Specialsymbol(Ex-Querty@1A))");
		String ch1 = null;
		char c1 = 'y';
		while (c1 == 'y') {
			ch1 = sc.next();
			if (Validations.isPassword(ch1)) {
				c1 = 'n';
			} else {
				log.info("Enter correct password pattern");
			}
		}
		dto.setPassword(ch1);

		log.info("Enter you Gender:");
		String usrName1 = sc.next();
		while (!Validations.isStringAlphabet(usrName1)) {
			log.info("Enter  only alphabets");
			log.info("Enter your Gender");
			usrName1 = sc.next();
			dto.setGender(usrName1);
		}
		dto.setGender(usrName1);

		log.info("Enter Address");
		String usrName2 = sc.next();
		while (!Validations.isStringAlphabet(usrName2)) {
			log.info("Enter  only alphabets");
			log.info("Enter Address");
			usrName2 = sc.next();
			dto.setAddress(usrName2);
		}
		dto.setAddress(usrName2);

		while (true) {
			log.info("Enter your Contact number");
			String patientNum = sc.next();
			long patNum = Main.phoneNumberValidate(patientNum);
			if (patNum == 0) {
				log.info("Invalid Number");
			} else {
				dto.setPhoneNumber(patNum);
				;
				break;
			}
		}

		if (service.updatePatient(dto)) {
			log.info("!!!!Patient successfully Updated!!!!");
		} else {
			log.info("!!!!Patient Updation unsuccesssfull!!!!");
		}
	}

	public void updateBooking() {

		int appId1 = 0;
		while (true) {
			log.info("Enter Appointment Id :-");
			String id = sc.next();
			if (Validations.isNumber(id)) {
				appId1 = Integer.parseInt(id);
				break;
			} else {
				log.info("Enter Proper Number");
			}
		}

		AppointmentDto appDto = appointmentService.getAppointment(appId1);
		log.info("Enter New Timings :- (DD-MM-YYYY/HH:MM)");
		String usrName = sc.next();
		while (!Validations.dateValidation(usrName)) {
			log.info("Enter correct date format");
			log.info("Enter New Timings");
			usrName = sc.next();
			appDto.setAppointmentDateandTime(usrName);
		}
		appDto.setAppointmentDateandTime(usrName);
		if (appointmentService.updateAppointment(appDto)) {
			log.info("Appointment Updated Successfully...");
		} else {
			log.info("Appointment Updation failed!!!");
		}

	}

	public void display() {

		List<AppointmentDto> appointmentdto = appointmentService.getAllAppointment();
		for (AppointmentDto a1 : appointmentdto) {
			log.info("--------------This is your Booking Info.-----------------------");
			log.info("Appointment Id is            :- " + a1.getAppointmentId());
			log.info("Doctor Id is                 :- " + a1.getDoctorId());
			log.info("Doctor Name is               :- " + a1.getDoctorName());
			log.info("Patient Id is                :- " + a1.getPatientId());
			log.info("Patient Name is              :- " + a1.getPatientName());
			log.info("Appointment Date and Time is :- " + a1.getAppointmentDateandTime());
			log.info("------------------------------------------------");
		}

	}

	public void search() {

		DoctorService doctorService = new DoctorServiceImpl();
		log.info("Enter Location:-");
		List<DoctorDetailsDto> doctordto = doctorService.searchDoctor(sc.next());
		for (DoctorDetailsDto d1 : doctordto) {
			log.info("*******************This is Doctor Info.*******************");
			log.info("Doctor Id is             :- " + d1.getDoctorId());
			log.info("Doctor Name is           :- " + d1.getDoctorName());
			log.info("Doctor Email is          :- " + d1.getEmailId());
			log.info("Doctor Specialization is :- " + d1.getSpecialization());
			log.info("Doctor Location is       :- " + d1.getLocation());
			log.info("Doctor Mobile no. is     :- " + d1.getContact());
			log.info("Doctor Timing's is       :- " + d1.getAvailability());
			log.info("Doctor Leave-Status is   :- " + d1.isLeaveStatus());
			log.info("***************************************************************");

		}

	}

	public void bookAppointment() {
		Integer doctorId = 0;
		while (true) {
			log.info("Enter Doctor Id :-");
			String id = sc.next();
			if (Validations.isNumber(id)) {
				doctorId = Integer.parseInt(id);
				break;
			} else {
				log.info("Enter Proper Number");
			}
		}
		AppointmentDto appdto = new AppointmentDto();
		for (DoctorDetailsDto docDto : doctordto) {
			if (doctorId.equals(docDto.getDoctorId())) {
				if (!(docDto.isLeaveStatus())) {
					appdto.setDoctorId(doctorId);
					appdto.setDoctorName(docDto.getDoctorName());
					appdto.setPatientId(patientId);
					appdto.setPatientName(patientName);
					log.info("Enter Appointment Date and Time:-(DD-MM-YYYY/HH:MM)");
					String usrName = sc.next();
					try {
						while (!Validations.dateValidation(usrName)) {
							log.info("Enter correct date format");
							log.info("Enter Appointment Date and Time");
							usrName = sc.next();
							appdto.setAppointmentDateandTime(usrName);
						}
					} catch (Exception e) {
						log.info("Enter correct date and time ");
					}
					appdto.setAppointmentDateandTime(usrName);

					while (true) {
						log.info("Enter Appoinment ID");
						String appoiId = sc.next();
						int appID = Main.numValidate(appoiId);
						if (appID == 0) {
							log.info("Invalid Appointment ID");
						} else {
							appdto.setAppointmentId(appID);
							break;
						}
					}
					if (service.registerAppointment(appdto)) {
						log.info("Appointment Booked Succesfully...");
						break;
					} else {
						log.info("Appointment Booking failed!!!");
					}
				} else {
					log.info("Doctor is on leave..No booking!!!");
				}
			} else {
				log.info("No Doctor for this Doctor Id!!!");
			}
		}

	}

	public void delete() {

		int patID = 0;
		while (true) {
			log.info("Enter Appointment Id :-");
			String id = sc.next();
			if (Validations.isNumber(id)) {
				patID = Integer.parseInt(id);
				break;
			} else {
				log.info("Enter Proper Number");
			}
		}
		AppointmentService service = new AppointmentServiceImpl();
		if (service.deleteAppointment(patID)) {
			log.info("Deleted Succesfully");
		} else {
			log.info("Deleted UnSuccesfull");
		}

	}

	public void viewPatientInfo() {
		PatientService patService = new PatientServiceImpl();
		List<PatientRegistrationDto> patientDto = patService.getAllPatient();
		for (PatientRegistrationDto p1 : patientDto) {
			log.info("*******************************************************");
			log.info("Patient Id is         :- " + p1.getPatientId());
			log.info("Patient Name is       :- " + p1.getPatientName());
			log.info("Patient Email is      :- " + p1.getEmailId());
			log.info("Patient Password is   :- " + p1.getPassword());
			log.info("Patient Gender is     :- " + p1.getGender());
			log.info("Patient Mobile No is  :- " + p1.getPhoneNumber());
			log.info("Patient Address is    :- " + p1.getAddress());
			log.info("*************************************************************");
		}

	}

	public void rating() {
		RatingService rateService = new RatingServiceImpl();
		RatingDto rateDto = new RatingDto();
		rateDto.setPatientId(patientId);
		rateDto.setPatientName(patientName);
		while (true) {
			log.info("Enter Doctor ID");
			String doctorId = sc.next();
			int docID = Main.numValidate(doctorId);
			if (docID == 0) {
				log.info("Invalid Doctor ID");
			} else {
				rateDto.setDoctorId(docID);
				break;
			}
		}

		log.info("Enter Doctor Name :- ");
		String usrName = sc.next();
		while (!Validations.isStringAlphabet(usrName)) {
			log.info("Enter valid name");
			log.info("Enter Doctor Name");
			usrName = sc.next();
			rateDto.setDoctorName(usrName);
		}
		rateDto.setDoctorName(usrName);

		log.info("Enter Rating :- ");
		String usrName7 = sc.next();
		while (!Validations.isStringAlphabet(usrName7)) {
			log.info("Enter only alphabets");
			log.info("Enter Rating :-");
			usrName7 = sc.next();
			rateDto.setRating(usrName7);
		}
		rateDto.setRating(usrName7);

		if (rateService.registerRating(rateDto)) {
			log.info("Rating successful...");
		} else {
			log.info("Rating Failed!!!");
		}

	}

	public void option() {
		while (true) {
			PatientController d1 = new PatientController();
			log.info("***************************************");
			log.info("Avaiable options you have--->:- ");
			log.info("Press 1 For Search Doctor");
			log.info("Press 2 For Book Appointment");
			log.info("Press 3 For Update Patient Details");
			log.info("Press 4 For Update Booking");
			log.info("Press 5 For Delete Booking");
			log.info("Press 6 For View Patient Info");
			log.info("Press 7 For View Booking");
			log.info("Press 8 For Add Rating");
			log.info("Press 9 For Logout");
			log.info("Enter Your Choice below--->");

			int option = Main.numValidate(sc.next());
			switch (option) {
			case 1:
				d1.search();
				break;
			case 2:
				d1.bookAppointment();
				break;

			case 3:
				d1.update();
				break;

			case 4:
				d1.updateBooking();
				break;

			case 5:
				d1.delete();
				break;

			case 6:
				d1.viewPatientInfo();
				break;

			case 7:
				d1.display();
				break;

			case 8:
				d1.rating();
				break;

			}

			if (option == 9) {
				break;
			}
		}

	}

}
