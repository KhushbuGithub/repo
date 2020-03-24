package com.capgemini.bookmydoctor.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.db.MyDoctorDB;
import com.capgemini.bookmydoctor.dto.AppointmentDto;
import com.capgemini.bookmydoctor.dto.DoctorDetailsDto;
import com.capgemini.bookmydoctor.service.AppointmentService;
import com.capgemini.bookmydoctor.service.AppointmentServiceImpl;
import com.capgemini.bookmydoctor.service.DoctorService;
import com.capgemini.bookmydoctor.service.DoctorServiceImpl;
import com.capgemini.bookmydoctor.validations.Validations;

public class DoctorController {

	static Logger log = Logger.getLogger(DoctorController.class);

	Scanner sc = new Scanner(System.in);
	private LinkedList<DoctorDetailsDto> doctordto = MyDoctorDB.doctordetailsDto;
	private LinkedList<AppointmentDto> appointmentdto = MyDoctorDB.appointmentDto;
	private DoctorService doctorService = new DoctorServiceImpl();
	private AppointmentService appointmentService = new AppointmentServiceImpl();

	static int doctorId = 0;
	String doctorName = null;

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
			for (DoctorDetailsDto doctorInfoDto : this.doctordto) {
				if (email.equals(doctorInfoDto.getEmailId()) && (password.equals(doctorInfoDto.getPassword()))) {
					DoctorController.doctorId = doctorInfoDto.getDoctorId();
					this.doctorName = doctorInfoDto.getDoctorName();
					log.info("Login Successful!!! Welcome to Doctor page ");
					return true;
				}
			}
			count++;
			log.info("Invalid Credentials!!!");
			if (count == 5) {
				break;
			}
		}
		return false;
	}

	public void updateDoctorDetails() {
		DoctorService service = new DoctorServiceImpl();
		DoctorDetailsDto dto = new DoctorDetailsDto();

		dto.setDoctorId(doctorId);

		dto.setDoctorName(doctorName);
		log.info("Enter Doctor EmailId");
		String ch = null;
		char c = 'y';
		while (c == 'y') {
			ch = sc.next();
			if (Validations.isEmail(ch)) {
				c = 'n';
			} else {
				log.info("Enter correct email pattern(Ex-sai@gmail.com)");
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
		log.info("Enter Specialization");
		String usrName1 = sc.next();
		while (!Validations.isStringAlphabet(usrName1)) {
			log.info("Enter only alphabets");
			log.info("Enter Specialization");
			usrName1 = sc.next();
			dto.setSpecialization(usrName1);
		}
		dto.setSpecialization(usrName1);
		log.info("Enter Availability");
		String usrName2 = sc.next();
		while (!Validations.isStringAlphabet(usrName2)) {
			log.info("Enter only alphabets");
			log.info("Enter Availability");
			usrName2 = sc.next();
			dto.setAvailability(usrName2);
		}
		dto.setAvailability(usrName2);
		log.info("Enter Location");
		String usrName3 = sc.next();
		while (!Validations.isStringAlphabet(usrName3)) {
			log.info("Enter only alphabets");
			log.info("Enter Location");
			usrName3 = sc.next();
			dto.setLocation(usrName3);
		}
		dto.setLocation(usrName3);
		while (true) {
			log.info("Enter Doctor Contact number");
			String doctorNum = sc.next();
			long docNum = Main.phoneNumberValidate(doctorNum);
			if (docNum == 0) {
				log.info("Invalid Doctor number");
			} else {
				dto.setContact(docNum);
				break;
			}
		}

		if (service.updateDoctor(dto)) {
			log.info("!!!!Doctor Details successfully Updated !!!!");
		} else {
			log.info("!!!!Doctor  Updation unsuccesssfull!!!!");
		}

	}

	public void viewAppointment() {

		List<AppointmentDto> appointmentdto = appointmentService.getAppointmentById(doctorId);
		for (AppointmentDto a1 : appointmentdto) {
			log.info("------------------------------------------------");
			log.info("Appointment Id is   :- " + a1.getAppointmentId());
			log.info("Doctor Id is        :- " + a1.getDoctorId());
			log.info("Doctor Name is      :- " + a1.getDoctorName());
			log.info("Patient Id is       :- " + a1.getPatientId());
			log.info("Patient Name is     :- " + a1.getPatientName());
			log.info("Appointment Date is :- " + a1.getAppointmentDateandTime());
			log.info("------------------------------------------------");
		}

	}

	public void viewDoctor() {
		DoctorService service = new DoctorServiceImpl();
		List<DoctorDetailsDto> doctorDto = service.getAllDoctor();
		for (DoctorDetailsDto d1 : doctorDto) {
			log.info("**************************************************************");
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

	public void updateAppointmentDetails() {
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
		log.info("Enter New Timings(DD-MM-YYYY/HH:MM) :- ");
		String usrName = sc.next();
		while (!Validations.dateValidation(usrName)) {
			log.info("Enter correct date and time format");
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

	public void delete() {
		AppointmentService service = new AppointmentServiceImpl();
		log.info("Enter AppointmentId");
		int appId = Main.numValidate(sc.next());
		if (service.deleteAppointment(appId)) {
			log.info("Appointment Record Deleted Successfully...");
		} else {
			log.info("appointment Record Deletion Failed!!!");
		}

	}

	public void option() {
		while (true) {
			DoctorController d1 = new DoctorController();
			log.info("");
			log.info("Avaiable options you have---> ");
			log.info("Press 1 For  View Appointment Details");
			log.info("Press 2 For  View Doctor Details");
			log.info("Press 3 For  Update Doctor Details");
			log.info("Press 4 For  Update Appointment Details");
			log.info("Press 5 For  Delete Appointment");
			log.info("Press 6 For  Logout");
			log.info("Enter Your Choice below--->");

			int option = Main.numValidate(sc.next());
			switch (option) {
			case 1:
				d1.viewAppointment();
				break;
			case 2:
				d1.viewDoctor();
				break;
			case 3:
				d1.updateDoctorDetails();
				break;
			case 4:
				d1.updateAppointmentDetails();
				break;

			case 5:
				d1.delete();
				break;

			}
			if (option == 6) {
				break;
			}
		}

	}
}
