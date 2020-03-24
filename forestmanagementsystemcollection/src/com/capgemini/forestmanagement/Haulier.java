package com.capgemini.forestmanagement;

import java.util.Scanner;

import com.capgemini.forestmanagement.beans.HaulierBean;
import com.capgemini.forestmanagement.dao.HaulierDAO;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;
import com.capgemini.forestmanagement.factory.HaulierFactory;
import com.capgemini.forestmanagement.validation.Validations;

public class Haulier {
	public static void haulierPage() {
		HaulierDAO dao = HaulierFactory.instanceOfHaulierDaoImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);

		while (true) {
			System.out.println("1.ADD HAULIER");
			System.out.println("2.DELETE HAULIER");
			System.out.println("3.MODIFY HAULIER");
			System.out.println("4.BACK");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter Haulier id");

				String haulierId;
				do {
					haulierId = sc.next();
					if (!Validations.isNumber(haulierId)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(haulierId));

				System.out.println("Enter The Haulier Name");

				String haulierName;

				do {
					haulierName = sc1.next();
					if (!(Validations.isWord(haulierName) && (haulierName.length() >= 3))) {

						System.err.println("Enter valid haulier name!!!");
					}
				} while (!(Validations.isWord(haulierName) && (haulierName.length() >= 3)));

				System.out.println("Enter the haulier Address1");

				String haulierAddress1;

				haulierAddress1 = sc.next();

				System.out.println("Enter the haulier Address2");

				String haulierAddress2;

				haulierAddress2 = sc1.next();

				System.out.println("Enter Town");

				String town = sc.next();

				System.out.println("enter the postal code");

				String postCode;

				do {

					postCode = sc.next();
					if (!(postCode.length() == 6)) {

						System.err.println("Enter 6 digit Pincode!!!");
					}
					if (!Validations.isNumber(postCode)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}

					}
				} while (!((postCode.length() == 6) && (Validations.isNumber(postCode))));

				System.out.println("Enter the telephone number");

				String tel;

				do {

					tel = sc.next();
					if (!(tel.length() == 10)) {

						System.err.println("Enter 10 digit Pincode!!!");
					}
					if (!Validations.isNumber(tel)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}

					}
				} while (!((tel.length() == 10) && (Validations.isNumber(tel))));

				System.out.println("Enter the number");

				String number;
				do {
					number = sc.next();
					if (!Validations.isNumber(number)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(number));

				System.out.println("Enter the email");

				String email;

				do {
					email = sc.next();

					if (!Validations.valEmail(email)) {

						System.err.println("Enter valid emailId (eg. abc26@gmail.com)");
					}

				} while (!Validations.valEmail(email));

				HaulierBean bean = new HaulierBean();
				bean.setHaulierId(Integer.parseInt(haulierId));
				bean.setHaulierName(haulierName);
				bean.setHaulierAddress1(haulierAddress1);
				bean.setHaulierAddress2(haulierAddress2);
				bean.setTown(town);
				bean.setPostCode(Integer.parseInt(postCode));
				bean.setTelephone(Integer.parseInt(tel));
				bean.setNumber(Integer.parseInt(number));
				bean.setEmail(email);

				boolean check = dao.addHaulier(bean);
				if (check) {
					System.out.println("Haulier added to the list");
				} else {
					System.out.println("Something went wrong");
				}
				break;
			case 2:

				System.out.println("Enter the haulier id to delete");

				String haulierid2;
				
				do {
					haulierid2 = sc.next();
					if (!Validations.isNumber(haulierid2)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(haulierid2));


				boolean check2 = dao.deleteHaulier(Integer.parseInt(haulierid2));
				if (check2) {
					System.out.println("Haulier details deleted");
				} else {
					System.err.println("No haulier details Found!!!");
				}
				break;
			case 3:
				System.out.println(" Modify Haulier Details");
				System.out.println("Enter Haulier id");
				String haulierId3;
				
				
				do {
					haulierId3 = sc.next();
					if (!Validations.isNumber(haulierId3)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(haulierId3));


				System.out.println("Enter The Haulier Name to be modified : ");

				String haulierName1;

				do {
					haulierName1 = sc1.next();
					if (!(Validations.isWord(haulierName1) && (haulierName1.length() >= 3))) {

						System.err.println("Enter haulier name!!!");
					}
				} while (!(Validations.isWord(haulierName1) && (haulierName1.length() >= 3)));

				System.out.println("Enter the haulier Address1");

				String haulierAddress11;

				haulierAddress11 = sc.next();

				System.out.println("Enter the haulier Address2");

				String haulierAddress22;

				haulierAddress22 = sc1.next();

				System.out.println("Enter Town");

				String town1 = sc.next();

				System.out.println("enter the postal code");

				String postCode1;

				do {

					postCode1 = sc.next();
					if (!(postCode1.length() == 6)) {

						System.err.println("Enter 6 digit Pincode!!!");
					}
					if (!Validations.isNumber(postCode1)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}

					}
				} while (!((postCode1.length() == 6) && (Validations.isNumber(postCode1))));

				System.out.println("Enter the telephone number");

				String telephoneNum1;
				do {

					telephoneNum1 = sc.next();
					if (!(telephoneNum1.length() == 10)) {

						System.err.println("Enter 10 digit Pincode!!!");
					}
					if (!Validations.isNumber(telephoneNum1)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}

					}
				} while (!((telephoneNum1.length() == 10) && (Validations.isNumber(telephoneNum1))));

				System.out.println("Enter the number");

				String num1;
				do {
					num1 = sc.next();
					if (!Validations.isNumber(num1)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(num1));

				System.out.println("Enter the email");

				String email1;

				do {
					email1 = sc.next();

					if (!Validations.valEmail(email1)) {

						System.err.println("Enter valid emailId (eg. abc26@gmail.com)");
					}

				} while (!Validations.valEmail(email1));

				HaulierBean bean1 = new HaulierBean();
				bean1.setHaulierId(Integer.parseInt(haulierId3));
				bean1.setHaulierName(haulierName1);
				bean1.setHaulierAddress1(haulierAddress11);
				bean1.setHaulierAddress2(haulierAddress22);
				bean1.setTown(town1);
				bean1.setPostCode(Integer.parseInt(postCode1));
				bean1.setTelephone(Integer.parseInt(telephoneNum1));
				bean1.setNumber(Integer.parseInt(num1));
				bean1.setEmail(email1);

				boolean check3 = dao.modifyHaulier(bean1);

				if (check3) {

					System.out.println("Haulier Details Modified...");

				} else {
					System.err.println("HaulierId Does'nt Exists!!!");
				}

				break;
			case 4:
				HomePage.homepage();
				break;
			default:
				System.err.println("Invalid Option!!!");
			}
		}
	}

}
