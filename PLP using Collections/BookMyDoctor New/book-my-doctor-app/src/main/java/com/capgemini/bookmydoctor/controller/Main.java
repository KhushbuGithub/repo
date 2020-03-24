package com.capgemini.bookmydoctor.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.bookmydoctor.validations.Validations;

public class Main {

	static Logger log = Logger.getLogger(Main.class);

	static int numValidate(String s) {
		try {
			if (Validations.isNumber(s)) {
				return Integer.parseInt(s);
			} else {
				log.info("Please!!!Enter valid input");
				return 0;
			}
		} catch (Exception e) {
			log.info("Enter valid input");
		}
		return 0;
	}

	static long phoneNumberValidate(String num) {
		if (Validations.phoneValidation(num)) {
			return Long.parseLong(num);
		} else {
			log.info(" Enter proper number");
			return 0;
		}
	}

	public final static void main(String[] args) {
		int user = 0;
		Scanner sc = new Scanner(System.in);

		log.info(
				"**********************************************************************************************************************************************************************************");
		log.info(
				"                                                               !!!!!Welcome to Book my Doctor Application!!!!!!");
		log.info(
				"**********************************************************************************************************************************************************************************");

		while (true) {
			log.info("******!!!Welcome To Home Page!!!Choose any User~~~~~~~~:-********** ");
			log.info("Avaiable options you have--->");
			log.info("Enter 1 For Admin");
			log.info("Enter 2 For Doctor");
			log.info("Enter 3 For Patient");
			log.info("Enter 4 For Exit");
			log.info("Press your choice below-->");

			int user1 = Main.numValidate(sc.nextLine());

			switch (user1) {

			case 1:
				AdminController admin = new AdminController();
				admin.login();
				admin.option();
				break;

			case 2:
				DoctorController doctor = new DoctorController();
				while (true) {
					log.info("***********Welcome to Doctor Page**************");
					log.info("Avaiable options you have --->");
					log.info("Enter 1 For Login");
					log.info("Enter 2 For Exit");
					log.info("Enter Your Choice below--->");

					int dOption = Main.numValidate(sc.nextLine());

					switch (dOption) {
					case 1:
						if (doctor.login()) {
							doctor.option();
						} else {
							log.info("Login Unsucessful");
						}
						break;

					}
					if (dOption == 2) {
						break;
					}

				}
				break;

			case 3:
				PatientController patient = new PatientController();
				while (true) {
					log.info("**********Welcome to Patient Page**************");
					log.info("Avaiable options you have--->");
					log.info("Enter 1 For Login");
					log.info("Enter 2 For Register");
					log.info("Enter 3 For Exit");
					log.info("Enter Your Choice below--->");

					int dOption = Main.numValidate(sc.nextLine());

					switch (dOption) {
					case 1:
						if (patient.login()) {
							patient.option();
						} else {
							log.info("Login Unsucessful");
						}
						break;
					case 2:
						patient.register();
						break;
					}
					if (dOption == 3) {
						break;
					}
				}
				break;
			}
			if (user1 == 4) {
				log.info("ThankYou for using Book My Doctor Application...!!!!!!!");
				break;
			}
		}

	}
}
