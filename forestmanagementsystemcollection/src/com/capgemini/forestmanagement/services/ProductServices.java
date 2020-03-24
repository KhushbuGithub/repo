package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagement.beans.ProductBean;

public interface ProductServices {
	boolean addProduct(ProductBean bean);

	boolean deleteProduct(int productid);

	boolean modifyproduct(ProductBean bean);

}
