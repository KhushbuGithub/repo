package com.capgemini.forestmanagement;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.beans.CustomerBean;
import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;
import com.capgemini.forestmanagement.factory.CustomerFactory;
import com.capgemini.forestmanagement.validation.Validations;

public class Customer {
	public static void customer() {
		CustomerDAO dao = CustomerFactory.instanceOfCustomerDaoImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);

		while (true) {
			System.out.println(
					"1.ADD CUSTOMER\n2.DELETE CUSTOMER\n3.SEARCH CUSTOMER\n4.GET CUSTOMER DETAILS\n5.MODIFY CUSTOMER DETAILS\n6.BACK");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Customer id");

				String customerid;
				do {
					customerid = sc.next();
					if (!Validations.isNumber(customerid)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(customerid));

				System.out.println("Enter customer name");

				String customerName;

				do {
					customerName = sc.next();
					if (!(Validations.isWord(customerName) && (customerName.length() >= 3))) {

						System.err.println("Enter valid Customer name!!!");
					}
				} while (!(Validations.isWord(customerName) && (customerName.length() >= 3)));

				System.out.println("Enter the street Address1");

				String streetAddress1;
				// do {
				streetAddress1 = sc1.next();

				// if(!(streetAddress1.length()>10)) {
				//
				// System.err.println("Enter Valid Address!!!");
				// }
				// }while(!(streetAddress1.length()>10));
				//

				System.out.println("Enter the street Address2");

				String streetAddress2;
				// do {
				streetAddress2 = sc.next();
				// if(!(streetAddress2.length()>10)) {
				//
				// System.err.println("Enter Valid Address!!!");
				// }
				// }while(!(streetAddress2.length()>10));
				//

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

				System.out.println("Enter the email");

				String email;

				do {
					email = sc.next();

					if (!Validations.valEmail(email)) {

						System.err.println("Please enter valid email(eg. abc26@gmail.com)!!!");
					}

				} while (!Validations.valEmail(email));

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

				CustomerBean bean = new CustomerBean();

				bean.setCustomerid(Integer.parseInt(customerid));
				bean.setCustomerName(customerName);
				bean.setEmail(email);
				bean.setPostalCode(Integer.parseInt(postCode));
				bean.setStreetAddress1(streetAddress1);
				bean.setStreetAddress2(streetAddress2);
				bean.setTelephoneNum(Integer.parseInt(tel));
				bean.setTown(town);

				boolean check = dao.addCustomer(bean);
				if (check) {
					System.out.println("Customer added to the list");
				} else {
					System.out.println("Something went wrong");
				}
				break;
			case 2:
				System.out.println("Enter the customer id which you want to delete");
				String customerid2 ;
				do {
					customerid2 = sc.next();
					if (!Validations.isNumber(customerid2)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(customerid2));

				boolean check2 = dao.deleteCustomer(Integer.parseInt(customerid2));
				if (check2) {
					System.out.println("customer details deleted");
				} else {
					System.err.println("Customer records not found!!!");
				}
				break;
			case 3:
				System.out.println("enter id to search the customer data");
				
				String customerid3;
				
				do {
					customerid3 = sc.next();
					if (!Validations.isNumber(customerid3)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(customerid3));

				
				
				
				CustomerBean customerBean = dao.getCustomer(Integer.parseInt(customerid3));
				if (customerBean != null) {
					System.out.println(customerBean.getCustomerid());
					System.out.println(customerBean.getCustomerName());
					System.out.println(customerBean.getEmail());
					System.out.println(customerBean.getPostalCode());
					System.out.println(customerBean.getStreetAddress1());
					System.out.println(customerBean.getStreetAddress2());
					System.out.println(customerBean.getTelephoneNum());
					System.out.println(customerBean.getTown());
				} else {
					System.err.println("Record does not exit");
				}
				break;
			case 4:

				List<CustomerBean> list = dao.getAllCustomer();
				int listlen = list.size();
				if (listlen != 0) {

					System.out.println("Displaying The Customer Details...");

					if (list != null) {

						for (CustomerBean user : list) {
							System.out.println(user);
						}
					}
				} else {
					System.err.println("No Customer Records Found!!!");
				}

				break;
			case 5:

				System.out.println("Modify Customer Records");
				System.out.println("enter id to modify the customer data");
				String customerid5;
				do {
					customerid5 = sc.next();
					if (!Validations.isNumber(customerid5)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(customerid5));

				System.out.println("Enter the customer name to be modified");
				String customerName2;

				do {
					customerName2 = sc.next();
					if (!(Validations.isWord(customerName2) && (customerName2.length() >= 3))) {

						System.err.println("Enter valid Customer name!!!");
					}
				} while (!(Validations.isWord(customerName2) && (customerName2.length() >= 3)));

				System.out.println("Enter the address of street1");
				String streetAddress11 = sc.next();
				System.out.println("Enter the address of street2");
				String streetAddress21 = sc.next();
				System.out.println("Enter the town");
				String town1 = sc.next();
				System.out.println("Enter the postal code");

				String postalCode1;

				do {

					postalCode1 = sc.next();
					if (!(postalCode1.length() == 6)) {

						System.err.println("Enter 6 digit Pincode!!!");
					}
					if (!Validations.isNumber(postalCode1)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}

					}
				} while (!((postalCode1.length() == 6) && (Validations.isNumber(postalCode1))));

				System.out.println("Enter the email");
				String email1;

				do {
					email1 = sc.next();

					if (!Validations.valEmail(email1)) {

						System.err.println("Please enter valid email(eg. abc26@gmail.com)!!!");
					}

				} while (!Validations.valEmail(email1));

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

				CustomerBean bean1 = new CustomerBean();

				bean1.setCustomerid(Integer.parseInt(customerid5));
				bean1.setCustomerName(customerName2);
				bean1.setEmail(email1);
				bean1.setPostalCode(Integer.parseInt(postalCode1));
				bean1.setStreetAddress1(streetAddress11);
				bean1.setStreetAddress2(streetAddress21);
				bean1.setTelephoneNum(Integer.parseInt(telephoneNum1));
				bean1.setTown(town1);

				boolean check3 = dao.modifyCustomer(bean1);

				if (check3) {

					System.out.println("Customer Details Modified...");

				} else {
					System.err.println("CustomerId Does'nt Exists!!!");
				}
				break;
			case 6:
				HomePage.homepage();
				break;
			default:
				System.err.println("Invalid Option!!!");
			}// End Of Switch

		}

	}
}
