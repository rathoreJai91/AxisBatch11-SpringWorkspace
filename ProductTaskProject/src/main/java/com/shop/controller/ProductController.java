package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Product;
import com.shop.service.ProductService;

@RestController
@RequestMapping("/api/p1")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
	}
	
	@GetMapping("/product")
	ResponseEntity<List<Product>> displayAllProducts() {
		return new ResponseEntity<List<Product>>(productService.displayAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/product/id/{id}")
	ResponseEntity<Product> searchById(@PathVariable int id) {
		return new ResponseEntity<Product>(productService.searchProductById(id) , HttpStatus.OK);
	}
	
	@GetMapping("/product/name/{name}")
	ResponseEntity<List<Product>> searchByName(@PathVariable String name) {
		return new ResponseEntity<List<Product>>(productService.searchProductByName(name), HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	ResponseEntity<Product> updateProduct(@PathVariable int id ,@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(id, product), HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	ResponseEntity<Product> deleteProduct(@PathVariable int id) {
		return new ResponseEntity<Product>(productService.deleteProductById(id), HttpStatus.OK);
	}
}