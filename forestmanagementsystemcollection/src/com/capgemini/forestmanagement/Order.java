package com.capgemini.forestmanagement;

import java.text.ParseException;
import java.util.Scanner;

import com.capgemini.forestmanagement.beans.OrderBean;
import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;
import com.capgemini.forestmanagement.factory.OrderFactory;
import com.capgemini.forestmanagement.validation.Validations;

public class Order {
	public static void order() {
		OrderDAO dao = OrderFactory.instanceOfOrderDaoImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.ADD ORDER");
			System.out.println("2.DELETE ORDER");
			System.out.println("3.BACK");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

				System.out.println("Enter order no");

				String orderNo;
				do {
					orderNo = sc.next();
					if (!Validations.isNumber(orderNo)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(orderNo));

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

				System.out.println("Enter Product id");

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

				// System.out.println("Enter The Delivery Date (DD/MM/YYYY)");

				// String deliveryDate;

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

				OrderBean bean1 = new OrderBean();
				bean1.setOrderNo(Integer.parseInt(orderNo));
				bean1.setCustomerId(Integer.parseInt(customerid));
				bean1.setProductId(Integer.parseInt(productId));
				bean1.setHaulierId(Integer.parseInt(haulierId));
				bean1.setDeliveryDate(deliveryDate);
				bean1.setQuantity(Integer.parseInt(quantity));

				boolean check = dao.addOrder(bean1);
				if (check) {
					System.out.println("Order Placed...");
				} else {
					System.out.println("Something went wrong!!!");
				}
				break;
			case 2:

				System.out.println("Enter the order no to delete");

				String orderid2;
				do {
					orderid2 = sc.next();
					if (!Validations.isNumber(orderid2)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(orderid2));

				boolean check2 = dao.deleteOrder(Integer.parseInt(orderid2));
				if (check2) {
					System.out.println("Order details deleted");
				} else {
					System.err.println("No Order Found!!!");
				}
				break;
			case 3:
				HomePage.homepage();
				break;

			default:
				System.err.println("Invalid Option!!!");
			}
		}
	}
}
