package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.beans.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO {
	private List<CustomerBean> customerBean = new ArrayList<CustomerBean>();

	@Override
	public boolean addCustomer(CustomerBean bean) {
		for (CustomerBean customerBean2 : customerBean) {
			if (customerBean2.getCustomerid() == bean.getCustomerid()) {
				return false;
			}

		}
		customerBean.add(bean);
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerid) {

		CustomerBean bean = null;
		for (CustomerBean customerBean2 : customerBean) {
			if (customerBean2.getCustomerid() == customerid) {
				bean = customerBean2;
			}

		}
		if (bean != null) {
			customerBean.remove(bean);
			return true;
		}

		return false;
	}

	@Override
	public CustomerBean getCustomer(int customerid) {
		for (CustomerBean customerBean2 : customerBean) {
			if (customerBean2.getCustomerid() == customerid) {
				return customerBean2;
			}
		}
		return null;
	}

	@Override
	public List<CustomerBean> getAllCustomer() {

		return customerBean;
	}

	@Override
	public boolean modifyCustomer(CustomerBean bean) {
		for (CustomerBean customerbean2 : customerBean) {
			if (customerbean2.getCustomerid() == bean.getCustomerid()) {

				customerBean.contains(bean);

				customerBean.add(bean);
				return true;
			}
		}

		return false;
	}

}
