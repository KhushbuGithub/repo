package com.capgemini.forestmanagement;

import java.text.ParseException;
import java.util.Scanner;

import com.capgemini.forestmanagement.beans.ContractorBean;
import com.capgemini.forestmanagement.dao.ContractorDAO;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;
import com.capgemini.forestmanagement.factory.ContractorFactory;
import com.capgemini.forestmanagement.validation.Validations;

public class Contractor {
	public static void contractor() {
		ContractorDAO dao = ContractorFactory.instanceOfContractorDaoImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.ADD CONTRACT");
			System.out.println("2.DELETE CONTRACT");
			System.out.println("3.BACK");
			/*
			 * String date=bean.getDeliveryDate(); ContractorBean bean=new ContractorBean();
			 */
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter Contract No");

				String contractorid;
				do {
					contractorid = sc.next();
					if (!Validations.isNumber(contractorid)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(contractorid));

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

				System.out.println("Enter The Product Id");

				String productId;
				do {
					productId = sc.next();
					if (!Validations.isNumber(productId)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(productId));

				System.out.println("Enter The Haulier Id");

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

				String deliveryDate = null;
				System.out.println("Enter delivery date(DD/MM/YYYY)");

				try {
					do {
						deliveryDate = sc.next();
						try {
							if (!Validations.deliveryDate(deliveryDate)) {
								try {
									throw new ForestrymanagementException("Please valid date format(DD/MM/YYYY)!!!");
								} catch (ForestrymanagementException e) {
									// e.printStackTrace();
								}
								// System.err.println("Please enter only digits!!!");
							}
						} catch (ParseException e1) {
							// e1.printStackTrace();
						}
						if (!Validations.isValidfuture(deliveryDate)) {
							try {
								throw new ForestrymanagementException("Please enter future digits!!!");
							} catch (ForestrymanagementException e) {
								// e.printStackTrace();
							}
						}
					} while (!((Validations.deliveryDate(deliveryDate)) && (Validations.isValidfuture(deliveryDate))));
				} catch (ParseException e) {
					// e.printStackTrace();
				}

				System.out.println("Enter The Delivery Day");

				String deliveryDay;

				do {
					deliveryDay = sc.next();
					if (!(Validations.DayValid(deliveryDay))) {

						System.err.println("Enter Valid Day!!!");
					}
				} while (!(Validations.DayValid(deliveryDay)));

				System.out.println("Enter the Quantity");

				String quantity;
				do {
					quantity = sc.next();
					if (!Validations.isNumber(quantity)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(quantity));

				ContractorBean bean = new ContractorBean();
				bean.setContractNo(Integer.parseInt(contractorid));
				bean.setCustomerId(Integer.parseInt(customerid));
				bean.setProductId(Integer.parseInt(productId));
				bean.setHaulierId(Integer.parseInt(haulierId));
				bean.setDeliveryDate(deliveryDate);
				bean.setDeliveryDay(deliveryDay);
				bean.setQuantity(Integer.parseInt(quantity));

				boolean check = dao.addContract(bean);
				if (check) {
					System.out.println("contract added to the list");
				} else {
					System.out.println("Something went wrong");
				}
				break;
			case 2:
				System.out.println("Enter the contract id to delete");

				String contractorid2;
				
				do {
					contractorid2 = sc.next();
					if (!Validations.isNumber(contractorid2)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(contractorid2));
				

				boolean check2 = dao.deleteContract(Integer.parseInt(contractorid2));

				if (check2) {
					System.out.println("contract details deleted");
				} else {
					System.err.println("No Contract Found!!!");
				}
				break;
			case 3:
				HomePage.homepage();
				break;
			default:

				System.out.println("Invalid Option!!!");
			}
		}
	}

}
