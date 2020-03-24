package com.capgemini.forestmanagement;

import java.util.Scanner;

import com.capgemini.forestmanagement.beans.ProductBean;
import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;
import com.capgemini.forestmanagement.factory.ProductFactory;
import com.capgemini.forestmanagement.validation.Validations;

public class Product {
	public static void product() {
		ProductDAO dao = ProductFactory.instanceOfProductDaoImpl();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.ADD PRODUCT");
			System.out.println("2.DELETE PRODUCT");
			System.out.println("3.MODIFY PRODUCT");
			System.out.println("4.BACK");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:

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

				System.out.println("Enter the product Name");

				String productName;

				do {
					productName = sc.next();
					if (!(Validations.isWord(productName) && (productName.length() >= 3))) {

						System.err.println("Enter valid product name!!!");
					}
				} while (!(Validations.isWord(productName) && (productName.length() >= 3)));

				System.out.println("Add product Description");

				String productDesp = sc.next();

				ProductBean bean = new ProductBean();
				bean.setProductid(Integer.parseInt(productId));
				bean.setProductName(productName);
				bean.setProductDesp(productDesp);
				boolean check = dao.addProduct(bean);
				if (check) {
					System.out.println("Product added to the list");
				} else {
					System.out.println("Something went wrong");
				}
				break;
			case 2:
				System.out.println("Enter the product id to delete");
				String productid2;
				do {
					productid2 = sc.next();
					if (!Validations.isNumber(productid2)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(productid2));

				boolean check2 = dao.deleteProduct(Integer.parseInt(productid2));
				if (check2) {
					System.out.println("product details deleted");
				} else {
					System.err.println("No product Found!!!");
				}
				break;
			case 3:
				System.out.println("Enter Product id");

				String productid3;
				do {
					productid3 = sc.next();
					if (!Validations.isNumber(productid3)) {
						try {
							throw new ForestrymanagementException("Please enter only digits!!!");
						} catch (ForestrymanagementException e) {
							// e.printStackTrace();
						}
						// System.err.println("Please enter only digits!!!");
					}
				} while (!Validations.isNumber(productid3));

				System.out.println("Enter the product Name");

				String productName1;

				do {
					productName1 = sc.next();
					if (!(Validations.isWord(productName1) && (productName1.length() >= 3))) {

						System.err.println("Enter valid product name!!!");
					}
				} while (!(Validations.isWord(productName1) && (productName1.length() >= 3)));

				System.out.println("Add product Description");

				String productDesp1 = sc.next();

				ProductBean bean1 = new ProductBean();
				bean1.setProductid(Integer.parseInt(productid3));
				bean1.setProductName(productName1);
				bean1.setProductDesp(productDesp1);

				boolean check3 = dao.modifyproduct(bean1);

				if (check3) {

					System.out.println("Order Details Modified...");

				} else {
					System.err.println("OrderNo Does'nt Exists!!!");
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
