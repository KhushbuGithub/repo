package com.capgemini.forestmanagement.beans;

public class CustomerBean {
	private int customerid;
	private String customerName;
	private String streetAddress1;
	private String streetAddress2;
	private String town;
	private int postalCode;
	private String email;
	private int telephoneNum;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephoneNum() {
		return telephoneNum;
	}

	public void setTelephoneNum(int telephoneNum) {
		this.telephoneNum = telephoneNum;
	}

	@Override
	public String toString() {
		System.out.println("*******************************");
		return "customerid = " + customerid + "\n" + "customerName=" + customerName + "\n" + "streetAddress1="
				+ streetAddress1 + "\n" + "streetAddress2=" + streetAddress2 + "\n" + "town=" + town + "\n"
				+ "postalCode=" + postalCode + "\n" + "email=" + email + "\n" + "telephoneNum=" + telephoneNum
				+ "\n*******************************";

	}

}
