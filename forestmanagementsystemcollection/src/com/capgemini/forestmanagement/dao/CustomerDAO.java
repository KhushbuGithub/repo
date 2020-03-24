package com.capgemini.forestmanagement.dao;

import java.util.List;

import com.capgemini.forestmanagement.beans.CustomerBean;

public interface CustomerDAO {
	boolean addCustomer(CustomerBean bean);

	boolean deleteCustomer(int customerid);

	boolean modifyCustomer(CustomerBean bean);

	CustomerBean getCustomer(int customerid);

	List<CustomerBean> getAllCustomer();

}
