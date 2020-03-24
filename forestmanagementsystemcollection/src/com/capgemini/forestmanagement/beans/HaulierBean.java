package com.capgemini.forestmanagement.beans;

public class HaulierBean {
	private int haulierId;
	private String haulierName;
	private String haulierAddress1;
	private String haulierAddress2;
	private String town;
	private int postCode;
	private int telephone;
	private int number;
	private String email;

	public int getHaulierId() {
		return haulierId;
	}

	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}

	public String getHaulierName() {
		return haulierName;
	}

	public void setHaulierName(String haulierName) {
		this.haulierName = haulierName;
	}

	public String getHaulierAddress1() {
		return haulierAddress1;
	}

	public void setHaulierAddress1(String haulierAddress1) {
		this.haulierAddress1 = haulierAddress1;
	}

	public String getHaulierAddress2() {
		return haulierAddress2;
	}

	public void setHaulierAddress2(String haulierAddress2) {
		this.haulierAddress2 = haulierAddress2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
