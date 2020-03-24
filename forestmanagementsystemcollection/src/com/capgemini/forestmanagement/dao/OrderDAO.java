package com.capgemini.forestmanagement.dao;

import com.capgemini.forestmanagement.beans.OrderBean;

public interface OrderDAO {
	boolean addOrder(OrderBean bean);

	boolean deleteOrder(int orderid);
}
