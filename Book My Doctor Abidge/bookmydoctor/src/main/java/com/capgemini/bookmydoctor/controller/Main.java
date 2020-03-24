package com.capgemini.bookmydoctor.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {

	static Logger log = LogManager.getLogger("Home");
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	log.info("***** Welcome To Book My Doctor*****");
	log.info("1.Admin Page ");
	log.info("2.Doctor Page ");
	log.info("3.Patient Page ");

	int option = sc.nextInt();
	
	if (option == 1) {
		log.info("*****Welcome To Admin Page *****");
		AdminController admincontrol = new AdminController();
		admincontrol.enterOptions();
		admincontrol.adminLogin();
		admincontrol.adminRegister();
		admincontrol.addDoctor();
		admincontrol.deleteDoctor();
		admincontrol.deletePatient();
		admincontrol.viewAppointments();
		admincontrol.viewDoctorInfo();
		admincontrol.updateAppointment();
		admincontrol.deleteAdmin();
	} else if(option == 2) {
		log.info("*****  Welcome To Doctor Page *****");
		DoctorController doctorcontrol = new DoctorController();
		doctorcontrol.enterOptions();
		
	} else if (option == 3) {
		log.info("***** Welcome To Patient Page *****");
		PatientController patientcontrol = new PatientController();
	} else {
		log.info("Invalid Option");
	}
	sc.close();
}
	
	
}
