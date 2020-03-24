package com.capgemini.forestmanagement;

import java.util.Scanner;

import com.capgemini.forestmanagement.exception.ForestrymanagementException;

public class HomePage {
	public static void homepage() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.CUSTOMER\n2.CONTRACTOR\n3.PRODUCT\n4.HAULIER\n5.ORDER\n6.EXIT");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				try {

					Customer.customer();

				} catch (Exception e) {

					try {

						throw new ForestrymanagementException("Please Enter Only Digits!!!");

					} catch (ForestrymanagementException e1) {

						try {
							Customer.customer();
						} catch (Exception e2) {
							try {
								throw new ForestrymanagementException("Please Enter Only Digits!!!");

							} catch (ForestrymanagementException e3) {
								Customer.customer();
								// e3.printStackTrace();
							}
						}
						// e1.printStackTrace();
					}
				}

				break;
			case 2:

				try {

					Contractor.contractor();

				} catch (Exception e) {

					try {

						throw new ForestrymanagementException("Please Enter Only Digits!!!");

					} catch (ForestrymanagementException e1) {

						try {
							Contractor.contractor();

						} catch (Exception e2) {
							try {
								throw new ForestrymanagementException("Please Enter Only Digits!!!");

							} catch (ForestrymanagementException e3) {
								Contractor.contractor();

								// e3.printStackTrace();
							}
						}
						// e1.printStackTrace();
					}
				}

				break;
			case 3:

				try {

					Product.product();

				} catch (Exception e) {

					try {

						throw new ForestrymanagementException("Please Enter Only Digits!!!");

					} catch (ForestrymanagementException e1) {

						try {
							Product.product();

						} catch (Exception e2) {
							try {
								throw new ForestrymanagementException("Please Enter Only Digits!!!");

							} catch (ForestrymanagementException e3) {
								Product.product();

								// e3.printStackTrace();
							}
						}

						// e1.printStackTrace();
					}
				}

				break;
			case 4:

				try {

					Haulier.haulierPage();

				} catch (Exception e) {

					try {

						throw new ForestrymanagementException("Please Enter Only Digits!!!");

					} catch (ForestrymanagementException e1) {

						try {
							Haulier.haulierPage();

						} catch (Exception e2) {
							try {
								throw new ForestrymanagementException("Please Enter Only Digits!!!");

							} catch (ForestrymanagementException e3) {
								Haulier.haulierPage();

								// e3.printStackTrace();
							}
						}

						// e1.printStackTrace();
					}
				}

				break;
			case 5:

				try {

					Order.order();

				} catch (Exception e) {

					try {

						throw new ForestrymanagementException("Please Enter Only Digits!!!");

					} catch (ForestrymanagementException e1) {

						try {
							Order.order();

						} catch (Exception e2) {
							try {
								throw new ForestrymanagementException("Please Enter Only Digits!!!");

							} catch (ForestrymanagementException e3) {
								Order.order();

								// e3.printStackTrace();
							}
						}
						// e1.printStackTrace();
					}
				}

				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.err.println("Invalid Option!!!");
			}
		}
	}
}
