package com.capgemini.forestmanagement.factory;

import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.dao.ProductDAOImpl;

public class ProductFactory {
	public static ProductDAO instanceOfProductDaoImpl() {
		ProductDAO dao = new ProductDAOImpl();
		return dao;
	}

}
