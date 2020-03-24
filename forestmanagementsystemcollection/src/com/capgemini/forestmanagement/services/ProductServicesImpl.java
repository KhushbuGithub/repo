package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.ProductBean;
import com.capgemini.forestmanagement.dao.ProductDAO;
import com.capgemini.forestmanagement.factory.ProductFactory;

public class ProductServicesImpl implements ProductServices {

	ProductDAO dao = ProductFactory.instanceOfProductDaoImpl();

	@Override
	public boolean addProduct(ProductBean bean) {

		return dao.addProduct(bean);
	}

	@Override
	public boolean deleteProduct(int productid) {

		return dao.deleteProduct(productid);
	}

	@Override
	public boolean modifyproduct(ProductBean bean) {

		return dao.modifyproduct(bean);
	}

}
