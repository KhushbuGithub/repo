package com.capgemini.productrestapi.dao;

import java.util.List;

import com.capgemini.productrestapi.dto.ProductInfoBean;

public interface ProductDAO {
	public boolean addProduct(ProductInfoBean bean);
	public boolean removeProduct(int id);
	public List<ProductInfoBean> getProductByName(String name);
	public List<ProductInfoBean> getAllProduct();
	public boolean updateProduct(ProductInfoBean bean);

}
