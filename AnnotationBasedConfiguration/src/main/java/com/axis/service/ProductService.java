package com.axis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axis.dao.ProductDao;

@Component // <bean id="productService" class="com.axis">
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public void productServiceLayer() {
		productDao.productDatabaseDao();
		System.out.println("Writing bussiness logic");
	}
}
