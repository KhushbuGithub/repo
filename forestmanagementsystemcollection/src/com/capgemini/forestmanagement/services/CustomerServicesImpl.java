package com.capgemini.forestmanagement.services;

import java.util.List;

import com.capgemini.forestmanagement.beans.CustomerBean;
import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.factory.CustomerFactory;

public class CustomerServicesImpl implements CustomerServices {
	CustomerDAO dao = CustomerFactory.instanceOfCustomerDaoImpl();

	@Override
	public boolean addCustomer(CustomerBean bean) {
		return dao.addCustomer(bean);
	}

	@Override
	public boolean deleteCustomer(int customerid) {

		return dao.deleteCustomer(customerid);
	}

	@Override
	public boolean modifyCustomer(CustomerBean bean) {

		return dao.modifyCustomer(bean);
	}

	@Override
	public CustomerBean getCustomer(int customerid) {
		// TODO Auto-generated method stub
		return dao.getCustomer(customerid);
	}

	@Override
	public List<CustomerBean> getAllCustomer() {

		return dao.getAllCustomer();
	}

}
