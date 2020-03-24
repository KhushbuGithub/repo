package com.capgemini.bookmydoctor.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.AdminDto;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.dto.PatientRegistrationDto;
import com.capgemini.bookmydoctor.dto.RatingDto;
import com.capgemini.bookmydoctor.service.AdminService;
import com.capgemini.bookmydoctor.service.AdminServiceImpl;
import com.capgemini.bookmydoctor.service.AppointmentService;
import com.capgemini.bookmydoctor.service.AppointmentServiceImpl;
import com.capgemini.bookmydoctor.service.DoctorService;
import com.capgemini.bookmydoctor.service.DoctorServiceImpl;
import com.capgemini.bookmydoctor.service.PatientService;
import com.capgemini.bookmydoctor.service.PatientServiceImpl;
import com.capgemini.bookmydoctor.service.RatingService;
import com.capgemini.bookmydoctor.service.RatingServiceImpl;
import com.capgemini.bookmydoctor.validations.Validations;

public class AdminController {

	static Logger log = Logger.getLogger(AdminController.class);

	private LinkedList<AdminDto> adminDto = MyDoctorDB.adminDto;
	private LinkedList<DoctorDetailsDto> doctorDetailsDto = MyDoctorDB.doctordetailsDto;
	private LinkedList<PatientRegistrationDto> patientRegistrationDto = MyDoctorDB.patientregistrationDto;
	private LinkedList<AppointmentDto> appointmentDto = MyDoctorDB.appointmentDto;
	private LinkedList<RatingDto> ratingDto = MyDoctorDB.ratingDto;

	Scanner s = new Scanner(System.in);

	public boolean login() {
		int count = 0;
		while (true) {
			log.info("Enter email(Ex:- sai@gmail.com)");
			String ch = null;
			char c = 'y';
			while (c == 'y') {
				ch = s.next();
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
				ch1 = s.next();
				if (Validations.isPassword(ch1)) {
					c1 = 'n';
				} else {
					log.info("Enter correct password pattern");
				}
			}
			String password = ch1;
			for (AdminDto adminInfo : this.adminDto) {
				if (email.equals(adminInfo.getAdminEmailId()) && (password.equals(adminInfo.getPassword()))) {
					log.info("****Welcome to Admin Page****");
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

	public void option() {
		AdminService adminService = new AdminServiceImpl();
		while (true) {

			log.info("***********************************************");
			log.info("Avaiable options you have---> ");
			log.info("Press 1 For  Doctor Info  ");
			log.info("Press 2 For  Patient Info  ");
			log.info("Press 3 For  Rating Info  ");
			log.info("Press 4 For  Appointment Info  ");
			log.info("Press 5 For  Display  ");
			log.info("Press 6 For  Back  ");
			log.info("Enter Your Choice below--->");

			int option = Main.numValidate(s.next());

			switch (option) {

			case 1:
				while (true) {
					DoctorService docService = new DoctorServiceImpl();
					log.info("*************************************");
					log.info("Avaiable options you have--->");
					log.info("Press 1 For View Doctor's Info  ");
					log.info("Press 2 For Register");
					log.info("Press 3 For Delete Doctor  ");
					log.info("Press 4 For Back  ");
					log.info("Enter Your Choice below--->");

					int doctorOption = Main.numValidate(s.next());

					switch (doctorOption) {
					case 1:
						List<DoctorDetailsDto> docDto = docService.getAllDoctor();
						for (DoctorDetailsDto d1 : docDto) {
							log.info("**************************************************************");
							log.info("Doctor Id is             :- " + d1.getDoctorId());
							log.info("Doctor Name is           :- " + d1.getDoctorName());
							log.info("Doctor Email is          :- " + d1.getEmailId());
							log.info("Doctor Specialization is :- " + d1.getSpecialization());

							log.info("Doctor Fees is           :- " + d1.getCharges());
							log.info("Doctor Location is       :- " + d1.getLocation());
							log.info("Doctor Mobile no. is     :- " + d1.getContact());

							log.info("***************************************************************");
						}
						break;
					case 2:

						DoctorService service = new DoctorServiceImpl();
						DoctorDetailsDto dto = new DoctorDetailsDto();

						while (true) {
							log.info("Enter Doctor ID");
							String doctorId = s.next();
							int docID = Main.numValidate(doctorId);
							if (docID == 0) {
								log.info("Invalid Doctor ID");
							} else {
								dto.setDoctorId(docID);
								break;
							}
						}
						log.info("Enter Doctor Name");
						String usrName = s.next();
						while (!Validations.isStringAlphabet(usrName)) {
							log.info("Enter valid name");
							log.info("Enter Doctor Name");
							usrName = s.next();
							dto.setDoctorName(usrName);
						}
						dto.setDoctorName(usrName);
						log.info("Enter Doctor EmailId(Ex-sai@gmail.com)");
						String ch = null;
						char c = 'y';
						while (c == 'y') {
							ch = s.next();
							if (Validations.isEmail(ch)) {
								c = 'n';
							} else {
								log.info("Enter correct email pattern");
							}
						}
						dto.setEmailId(ch);
						log.info(
								"Enter Password(Atleast min 8 max 16,One Integer,One Capsletter,One Specialsymbol(Ex-Querty@1A)");
						String ch1 = null;
						char c1 = 'y';
						while (c1 == 'y') {
							ch1 = s.next();
							if (Validations.isPassword(ch1)) {
								c1 = 'n';
							} else {
								log.info("Enter correct password pattern");
							}
						}
						dto.setPassword(ch1);
						log.info("Enter Specialization");
						String usrName1 = s.next();
						while (!Validations.isStringAlphabet(usrName1)) {
							log.info("Enter valid name");
							log.info("Enter Specialization");
							usrName1 = s.next();
							dto.setSpecialization(usrName1);
						}
						dto.setSpecialization(usrName1);
						log.info("Enter Availability");
						String usrName2 = s.next();
						while (!Validations.isStringAlphabet(usrName2)) {
							log.info("Enter valid name");
							log.info("Enter Availability");
							usrName2 = s.next();
							dto.setAvailability(usrName2);
						}
						log.info("Enter Location");
						String usrName3 = s.next();
						while (!Validations.isStringAlphabet(usrName3)) {
							log.info("Enter valid name");
							log.info("Enter Location");
							usrName3 = s.next();
							dto.setLocation(usrName3);
						}
						dto.setLocation(usrName3);
						while (true) {
							log.info("Enter Charges");
							String doctorId = s.next();
							int docID = Main.numValidate(doctorId);
							if (docID == 0) {
								log.info("Invalid input ");
							} else {
								dto.setCharges(docID);
								break;
							}
						}

						while (true) {
							log.info("Enter Doctor Mobile number");
							String doctorNum = s.next();
							long docNum = Main.phoneNumberValidate(doctorNum);
							if (docNum == 0) {
								log.info("Invalid Doctor number");
							} else {
								dto.setContact(docNum);
								break;
							}
						}

						for (DoctorDetailsDto docInfo : doctorDetailsDto) {
							if (!(dto.getEmailId().equals(docInfo.getEmailId())
									&& (docInfo.getDoctorId() == dto.getDoctorId()))) {
								if (docService.registerDoctor(dto)) {
									log.info("Doctor registered successfully...");
								} else {
									log.info("Registration Failed!! ID already Exist!!!");

								}
							} else if (dto.getEmailId().equals(docInfo.getEmailId())) {
								log.info("Registration failed!!Email already Exist!!!");
							} else {
								log.info("Duplicate Id!!!");
							}
							break;
						}
						break;

					case 3:
						int docId = 0;
						while (true) {
							log.info("Enter Doctor's Id :-");
							String id = s.next();
							if (Validations.isNumber(id)) {
								docId = Integer.parseInt(id);
								break;
							} else {
								log.info("Enter Proper Number");
							}
						}
						if (docService.deleteDoctor(docId)) {
							log.info("Doctor Record Deleted Successfully...");
						} else {
							log.info("Doctor Record Deletion Failed!!!");

						}
						break;
					}
					if (doctorOption == 4) {
						break;
					}
				}
				break;

			case 2:

				while (true) {
					PatientService patService = new PatientServiceImpl();
					log.info("Avaiable options you have---> ");
					log.info("Press 1 For View Patient Info ");
					log.info("Press 2 For Delete Patient ");
					log.info("Press 3 For Back  ");
					log.info("Enter Your Choice below--->");

					int patOption = Main.numValidate(s.next());

					switch (patOption) {
					case 1:
						List<PatientRegistrationDto> patientDto = patService.getAllPatient();
						for (PatientRegistrationDto p1 : patientDto) {
							log.info("*******************************************************");
							log.info("Patient Id is         :- " + p1.getPatientId());
							log.info("Patient Name is       :- " + p1.getPatientName());
							log.info("Patient Email is      :- " + p1.getEmailId());
							log.info("Patient Password is   :- " + p1.getPassword());
							log.info("Patient Gender is     :- " + p1.getGender());
							log.info("Patient Age is        :- " + p1.getAge());
							log.info("Patient Mobile No is  :- " + p1.getPhoneNumber());
							log.info("Patient Address is    :- " + p1.getAddress());
							log.info("*************************************************************");
						}
						break;
					case 2:
						int patId = 0;
						while (true) {
							log.info("Enter Patient's Id :-");
							String id = s.next();
							if (Validations.isNumber(id)) {
								patId = Integer.parseInt(id);
								break;
							} else {
								log.info("Enter Proper Number");
							}
						}
						if (patService.deletePatient(patId)) {
							log.info("Patient Record Deleted Successfully...");
						} else {
							log.info("Patient Record Deletion Failed!!!");
						}
						break;
					}
					if (patOption == 3) {
						break;
					}
				}
				break;

			case 3:

				while (true) {
					RatingService rateService = new RatingServiceImpl();
					log.info("Avaiable options you have---> ");
					log.info("Press 1 - View Rating Details ");
					log.info("Press 2 - Delete Rating Record ");
					log.info("Press 3 - Back ");
					log.info("Enter Your Choice below--->");

					int rateOption = Main.numValidate(s.next());

					switch (rateOption) {
					case 1:
						List<RatingDto> rateDto = rateService.getAllRating();
						for (RatingDto r1 : rateDto) {
							log.info("***************************************************");
							log.info("Patient Id is    :- " + r1.getPatientId());
							log.info("Patient Name is  :- " + r1.getPatientName());
							log.info("Doctor Id is     :- " + r1.getDoctorId());
							log.info("Doctor Name is   :- " + r1.getDoctorName());
							log.info("Rating is        :- " + r1.getRating());
							log.info("****************************************************");
						}
						break;
					case 2:
						log.info("Enter Patient Id :- ");
						if (rateService.deleteRating(Main.numValidate(s.next()))) {
							log.info("Rating Record Deleted Successfully...");
						} else {
							log.info("Rating Record Deletion Failed!!!");
						}
						break;
					}
					if (rateOption == 3) {
						break;
					}
				}
				break;

			case 4:
				while (true) {
					AppointmentService appService = new AppointmentServiceImpl();
					log.info("");
					log.info("Avaiable options you have--->");
					log.info("Press 1 For View Appointment Info  ");
					log.info("Press 2 For Update Appointment Info  ");
					log.info("Press 3 For Delete Appointment   ");
					log.info("Press 4 For Back  ");
					log.info("Enter Your Choice below--->");

					int appOption = Main.numValidate(s.next());

					switch (appOption) {
					case 1:
						List<AppointmentDto> appDto = appService.getAllAppointment();
						for (AppointmentDto a1 : appDto) {
							log.info("********************************************************************");
							log.info("Appointment Id is     :- " + a1.getAppointmentId());
							log.info("Doctor Id is          :- " + a1.getDoctorId());
							log.info("Doctor Name is        :- " + a1.getDoctorName());
							log.info("Patient Id is         :- " + a1.getPatientId());
							log.info("Patient Name is       :- " + a1.getPatientName());
							log.info("Appointment Date is   :- " + a1.getAppointmentDateandTime());
							log.info("*********************************************************************");
						}
						break;
					case 2:
						AppointmentDto appointDto = new AppointmentDto();
						while (true) {
							log.info("Enter Appoinment ID");
							String appoiId = s.next();
							int appID = Main.numValidate(appoiId);
							if (appID == 0) {
								log.info("Invalid Appointment ID");
							} else {
								appointDto.setAppointmentId(appID);
								break;
							}
						}

						while (true) {
							log.info("Enter Patient ID");
							String patientId = s.next();
							int patID = Main.numValidate(patientId);
							if (patID == 0) {
								log.info("Give Valid Patient ID");
							} else {
								appointDto.setPatientId(patID);
								break;
							}
						}
						log.info("Enter Patient Name :-");
						String usrName5 = s.next();
						while (!Validations.isStringAlphabet(usrName5)) {
							log.info("Enter valid name");
							log.info("Enter Patient Name");
							usrName5 = s.next();
							appointDto.setPatientName(usrName5);
						}
						appointDto.setPatientName(usrName5);
						while (true) {
							log.info("Enter Doctor ID");
							String doctorId = s.next();
							int docID = Main.numValidate(doctorId);
							if (docID == 0) {
								log.info("Invalid Doctor ID");
							} else {
								appointDto.setDoctorId(docID);
								break;
							}
						}
						log.info("Enter Doctor Name");
						String usrName = s.next();
						while (!Validations.isStringAlphabet(usrName)) {
							log.info("Enter Valid name");
							log.info("Enter Doctor Name");
							usrName = s.next();
							appointDto.setDoctorName(usrName);
						}
						appointDto.setDoctorName(usrName);
						log.info("Enter Appointment Timings(dd-MM-yyyy/hh:mm) :-");
						String usrName4 = s.next();
						while (!Validations.dateValidation(usrName4)) {
							log.info("Enter correct date and time format");
							log.info("Enter New Timings");
							usrName4 = s.next();
							appointDto.setAppointmentDateandTime(usrName4);
						}
						appointDto.setAppointmentDateandTime(usrName4);
						if (appService.updateAppointment(appointDto)) {
							log.info("Appointment Updated Successfully...");
						} else {
							log.info("Appointment Updation Failed!!!");
						}
						break;
					case 3:
						log.info("Enter Appointment Id :- ");
						int appId = Main.numValidate(s.next());
						if (appService.deleteAppointment(appId)) {
							log.info("Appointment Record Deleted Successfully...");
						} else {
							log.info("Appointment Record Deletion Failed!!!");
						}
						break;
					}
					if (appOption == 4) {
						break;
					}
				}
				break;

			case 5:
				LinkedList<AdminDto> adminDto = MyDoctorDB.adminDto;
				for (AdminDto adminD2 : adminDto) {
					log.info(adminD2);
					log.info("--------------");
				}
				break;
			}
			if (option == 6) {
				break;
			}
		}

	}
}