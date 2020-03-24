package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagement.beans.ProductBean;
import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dao.ProductDAOImpl;
import com.capgemini.forestmanagement.exception.ForestrymanagementException;


class ProductDAOImplTest {

	private ProductDAO dao= new ProductDAOImpl();
	private ProductBean product=new ProductBean();

	@BeforeEach
	void addProduct() {
		product.setProductid(2019001);
		product.setProductDesp("gfhgs");
		product.setProductName("vasd");
		dao.addProduct(product);
	}


	@Test
	void testAddProduct() {
		product= new ProductBean();
		product.setProductid(2019002);
		product.setProductDesp("gfhgs");
		product.setProductName("vadfg");
		

		try {
			boolean flag=dao.addProduct(product);
			assertEquals(flag, true);
			
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.addProduct(product);
			});
			
		}
	}

	@Test
	void testDeleteProduct() {
		product= new ProductBean();
		product.setProductid(2019001);
		try {
			boolean flag=dao.deleteProduct(product.getProductid());
			assertEquals(flag, true);
			
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.deleteProduct(product.getProductid());
			});
			
		}
	}

	@Test
	void testModifyproduct() {
		product.setProductid(2019002);
		product.setProductName("vaishna");
		product.setProductDesp("sdfghj");
		
		try {
			boolean flag = dao.modifyproduct(product) ;
			assertEquals(flag, true);
		}catch(Exception e) {
			assertThrows(ForestrymanagementException.class, () -> {
				dao.modifyproduct(product);
			});
			
		}
	}

}
