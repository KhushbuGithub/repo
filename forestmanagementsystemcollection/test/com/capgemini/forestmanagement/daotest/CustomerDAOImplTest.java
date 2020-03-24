package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.beans.CustomerBean;
import com.capgemini.forestmanagement.dao.CustomerDAO;
import com.capgemini.forestmanagement.dao.CustomerDAOImpl;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;

class CustomerDAOImplTest {

	private CustomerDAO dao =new CustomerDAOImpl();
	private CustomerBean customer= new CustomerBean();

	@BeforeEach
	void addCustomer() {
		customer.setCustomerid(2019001);
		customer.setCustomerName("vaishnasakthivel");
		customer.setStreetAddress1("sdfghjk");
		customer.setStreetAddress2("lkjhgfd");
		customer.setTown("xcxjh");
		customer.setPostalCode(123456);
		customer.setEmail("jhdsj56@gmail.com");
		customer.setTelephoneNum(123456789);
		dao.addCustomer(customer);
	}

	@Test
	void testAddCustomer() {
		customer= new CustomerBean();
		customer.setCustomerid(2019002);
		customer.setCustomerName("vaishna");
		customer.setStreetAddress1("sdfk");
		customer.setStreetAddress2("lkjh");
		customer.setTown("xcxh");
		customer.setPostalCode(123456);
		customer.setEmail("jhdsj56@gmail.com");
		customer.setTelephoneNum(123456789);
		try {
			boolean flag=dao.addCustomer(customer);
			assertEquals(flag,true);
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.addCustomer(customer);
			});

		}
	}

	@Test
	void testDeleteCustomer() {
		customer= new CustomerBean();
	    customer.setCustomerid(2019001);
	    try {
			boolean flag=dao.deleteCustomer(customer.getCustomerid());
			assertEquals(flag,true);
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.deleteCustomer(customer.getCustomerid());
		});

		}
	   
	}

	@Test
	void testGetCustomer() {
		customer= new CustomerBean();
		customer.setCustomerid(2019001);
		 try {
				CustomerBean bean=dao.getCustomer(customer.getCustomerid());
				assertNotNull(bean);
			}catch(Exception e) {
				assertThrows(ForestrymanagementException.class, () -> {
					dao.getCustomer(customer.getCustomerid());
			});

			}	
	}

	@Test
	void testGetAllCustomer() {
		List<CustomerBean> allCustomer = dao.getAllCustomer();
		assertNotNull(allCustomer);
	}

	@Test
	void testModifyCustomer() {
		customer= new CustomerBean();
		customer.setCustomerid(2019001);
		customer.setCustomerName("vaishna");
		customer.setStreetAddress1("sdfghjk");
		customer.setStreetAddress2("lkjhgfd");
		customer.setTown("xcxjh");
		customer.setPostalCode(123456);
		customer.setEmail("jhdsj56@gmail.com");
		customer.setTelephoneNum(123456789);
		 try {
				boolean flag=dao.modifyCustomer(customer);
				assertEquals(flag,true);
			}catch(Exception e) {
				assertThrows(ForestrymanagementException.class, () -> {
					dao.getCustomer(customer.getCustomerid());
			});

			}
	}

}
