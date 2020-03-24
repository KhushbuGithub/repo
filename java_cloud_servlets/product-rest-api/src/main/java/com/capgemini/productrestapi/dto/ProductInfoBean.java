package com.capgemini.productrestapi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product_info")
public class ProductInfoBean {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(unique=true)
	private String name;
	@Column
	private double price;
	@Column
	private int quality;
	@Column
	private String description;
	@Column
	private String imageurl;
}
