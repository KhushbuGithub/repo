package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.dao.OrderDAOImpl;

public class OrderFactory {
	public static OrderDAO instanceOfOrderDaoImpl() {
		OrderDAO dao = new OrderDAOImpl();
		return dao;
	}
}
