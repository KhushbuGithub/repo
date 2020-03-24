package com.capgemini.forestmanagement.services;

import java.util.List;

import com.capgemini.forestmanagement.beans.CustomerBean;

public interface CustomerServices {
	boolean addCustomer(CustomerBean bean);

	boolean deleteCustomer(int customerid);

	boolean modifyCustomer(CustomerBean bean);

	CustomerBean getCustomer(int customerid);

	List<CustomerBean> getAllCustomer();
}
