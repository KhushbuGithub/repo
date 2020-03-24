package com.capgemini.forestmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.forestmanagement.beans.ProductBean;

public class ProductDAOImpl implements ProductDAO {
	private List<ProductBean> productBean = new ArrayList<ProductBean>();

	@Override
	public boolean addProduct(ProductBean bean) {
		for (ProductBean productBean2 : productBean) {
			if (productBean2.getProductid() == bean.getProductid()) {
				return false;
			}

		}
		productBean.add(bean);
		return true;

	}

	@Override
	public boolean deleteProduct(int productid) {
		ProductBean bean = null;
		for (ProductBean customerBean2 : productBean) {
			if (customerBean2.getProductid() == productid) {
				bean = customerBean2;
			}

		}
		if (bean != null) {
			productBean.remove(bean);
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyproduct(ProductBean bean) {
		for (ProductBean product : productBean) {
			if (product.getProductid() == bean.getProductid()) {

				productBean.contains(bean);

				productBean.add(bean);
				return true;
			}
		}

		return false;
	}

}
