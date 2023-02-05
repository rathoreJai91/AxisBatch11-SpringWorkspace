package com.shop.service;

import java.util.List;

import com.shop.entity.Product;

public interface ProductService {

	Product addProduct(Product product);
	List<Product> displayAllProducts();
	Product searchProductById(int id);
	List<Product> searchProductByName(String name);
	Product updateProduct(int id , Product product);
	Product deleteProductById(int id);
}
