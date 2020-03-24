package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.beans.OrderBean;

public class OrderDAOImpl implements OrderDAO {

	private List<OrderBean> orderBean = new ArrayList<OrderBean>();

	@Override
	public boolean addOrder(OrderBean bean) {
		for (OrderBean orderBean2 : orderBean) {
			if (orderBean2.getOrderNo() == bean.getOrderNo()) {
				return false;
			}

		}
		orderBean.add(bean);
		return true;
	}

	@Override
	public boolean deleteOrder(int orderid) {
		OrderBean bean = null;
		for (OrderBean orderBean2 : orderBean) {
			if (orderBean2.getOrderNo() == orderid) {
				bean = orderBean2;
			}

		}
		if (bean != null) {
			orderBean.remove(bean);
			return true;
		}

		return false;
	}

}
