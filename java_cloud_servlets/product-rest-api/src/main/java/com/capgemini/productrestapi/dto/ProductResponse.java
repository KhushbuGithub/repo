package com.capgemini.productrestapi.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductResponse {
	private int statuscode;
	private String message;
	private String description;
	private List<ProductInfoBean> prods;
}
