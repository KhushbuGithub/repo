package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.dao.CustomerDAOImpl;

public class CustomerFactory {

	public static CustomerDAO instanceOfCustomerDaoImpl() {
		CustomerDAO dao = new CustomerDAOImpl();
		return dao;
	}

}
