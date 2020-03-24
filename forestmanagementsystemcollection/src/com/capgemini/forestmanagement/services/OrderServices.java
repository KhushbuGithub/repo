package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.OrderBean;

public interface OrderServices {
	boolean addOrder(OrderBean bean);

	boolean deleteOrder(int orderid);
}
