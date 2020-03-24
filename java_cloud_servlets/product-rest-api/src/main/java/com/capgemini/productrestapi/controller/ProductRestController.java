package com.capgemini.productrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.productrestapi.dto.ProductInfoBean;
import com.capgemini.productrestapi.dto.ProductResponse;
import com.capgemini.productrestapi.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	public ProductService service;

	@PostMapping(path = "/add-product",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductInfoBean beans) {
		ProductResponse response = new ProductResponse();
		if (service.addProduct(beans)) {
			response.setStatuscode(201);
			response.setMessage("Successfull");
			response.setDescription("Product inserted successfully into DB");
		} else {
			response.setStatuscode(401);
			response.setMessage("Unsuccessfull");
			response.setDescription("Inserting product has failed");
		}
		return response;
	}

	@DeleteMapping(path = "/delete/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse remove(@PathVariable("id") int id) {
		ProductResponse response = new ProductResponse();
		if (service.removeProduct(id)) {
			response.setStatuscode(201);
			response.setMessage("Successfull");
			response.setDescription("Product deleted successfully from DB");
		} else {
			response.setStatuscode(401);
			response.setMessage("Unsuccessfull");
			response.setDescription("Product deletion failed");
		}
		return response;
	}

	@PostMapping(path = "/update", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse update(@RequestBody ProductInfoBean beans) {
		ProductResponse response = new ProductResponse();
		if (service.updateProduct(beans)) {
			response.setStatuscode(201);
			response.setMessage("Successfull");
			response.setDescription("Updation Successful");
		} else {
			response.setStatuscode(401);
			response.setMessage("Unsuccessfull");
			response.setDescription("Updation UnSuccessful");
		}
		return response;
	}

	@GetMapping(path = "/getproduct",
			produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public ProductResponse getProd(@RequestParam("name") String name) {
		ProductResponse response = new ProductResponse();
		List<ProductInfoBean> beans = service.getProductByName(name);
		if (beans != null && !beans.isEmpty()) {
			response.setStatuscode(201);
			response.setMessage("Successfull");
			response.setDescription("The product with given name is found");
			response.setProds(beans);
		} else {
			response.setStatuscode(401);
			response.setMessage("Unsuccessfull");
			response.setDescription("The product with given name is not found");
		}
		return response;
	}
	
	@GetMapping(path="/getall",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getAll() {
		ProductResponse response = new ProductResponse();
		List<ProductInfoBean> beans = service.getAllProduct();
		if (beans != null) {
			response.setStatuscode(201);
			response.setMessage("Successfull");
			response.setDescription("Products Found in DB");
			response.setProds(beans);
		} else {
			response.setStatuscode(401);
			response.setMessage("Unsuccessfull");
			response.setDescription("Products not found");
		}
		return response;
	}

}
