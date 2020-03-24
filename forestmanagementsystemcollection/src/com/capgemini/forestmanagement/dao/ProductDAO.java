package com.capgemini.forestmanagement.dao;

import com.capgemini.forestmanagement.beans.ProductBean;

public interface ProductDAO {
	boolean addProduct(ProductBean bean);

	boolean deleteProduct(int productid);

	boolean modifyproduct(ProductBean bean1);

}
