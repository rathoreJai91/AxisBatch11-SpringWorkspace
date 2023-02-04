package com.axis.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.axis.service.ProductService;

public class ProductClient {
	
	public static void main(String[] args) {
		//tells about the beans and containers
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.axis"); // -->@Component
		context.refresh();
		
		ProductService productService = (ProductService) context.getBean("productService");
		productService.productServiceLayer();
		
		context.close();
	}
}