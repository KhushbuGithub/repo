package com.capgemini.productspringboot.service;

import java.util.List;

import com.capgemini.productspringboot.dto.ProductInfoBean;

public interface ProductService {
	public boolean addProduct(ProductInfoBean bean);

	public boolean removeProduct(int id);

	public List<ProductInfoBean> getProductByName(String name);

	public List<ProductInfoBean> getAllProduct();

	public boolean updateProduct(ProductInfoBean bean);

}
