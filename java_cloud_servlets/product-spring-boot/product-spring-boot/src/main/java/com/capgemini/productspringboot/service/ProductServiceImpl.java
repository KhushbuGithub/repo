package com.capgemini.productspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.productspringboot.dao.ProductDAO;
import com.capgemini.productspringboot.dto.ProductInfoBean;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO dao;

	@Override
	public boolean addProduct(ProductInfoBean bean) {
		 return dao.addProduct(bean);
	}

	@Override
	public boolean removeProduct(int id) {
	         return dao.removeProduct(id);
	}

	@Override
	public List<ProductInfoBean> getProductByName(String name) {
		return dao.getProductByName(name);
	}

	@Override
	public List<ProductInfoBean> getAllProduct() {
		return dao.getAllProduct();
	}

	@Override
	public boolean updateProduct(ProductInfoBean bean) {
		return dao.updateProject(bean);
	}

}
