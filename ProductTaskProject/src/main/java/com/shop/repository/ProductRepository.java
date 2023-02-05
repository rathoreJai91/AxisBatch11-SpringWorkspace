package com.shop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shop.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

	List<Product> findByName(String name);
	
}
