package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.beans.OrderBean;
import com.capgemini.forestmanagement.dao.OrderDAO;
import com.capgemini.forestmanagement.dao.OrderDAOImpl;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;

class OrderDAOImplTest {

	private OrderBean order= new OrderBean();
	private OrderDAO dao=new OrderDAOImpl();
	
	@BeforeEach
	void addOrder() {
		order.setOrderNo(2019001);
		order.setCustomerId(2019001);
		order.setProductId(2019001);
		order.setHaulierId(2019001);
		order.setDeliveryDate("22/12/2020");
		order.setDeliveryDay("wed");
		order.setQuantity(100);
		dao.addOrder(order);	
	}
	
	
	@Test
	void testAddOrder() {
		order=new OrderBean();
		order.setOrderNo(2019002);
		order.setCustomerId(2019001);
		order.setProductId(2019001);
		order.setHaulierId(2019001);
		order.setDeliveryDate("12/12/2020");
		order.setDeliveryDay("mon");
		order.setQuantity(100);
		try {
			boolean flag=dao.addOrder(order);
			assertEquals(flag,true);
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.addOrder(order);
			});

		}
	}

	@Test
	void testDeleteOrder() {
		order=new OrderBean();
		order.setOrderNo(2019001);
		try {
			boolean flag=dao.deleteOrder(order.getOrderNo());
			assertEquals(flag,true);
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.deleteOrder(order.getOrderNo());
			});

		}
		
	}

}
