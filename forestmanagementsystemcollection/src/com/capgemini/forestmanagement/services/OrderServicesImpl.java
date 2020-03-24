package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.OrderBean;
import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.factory.OrderFactory;

public class OrderServicesImpl implements OrderServices {
	OrderDAO dao = OrderFactory.instanceOfOrderDaoImpl();

	@Override
	public boolean addOrder(OrderBean bean) {

		return dao.addOrder(bean);
	}

	@Override
	public boolean deleteOrder(int orderid) {

		return dao.deleteOrder(orderid);
	}

}
