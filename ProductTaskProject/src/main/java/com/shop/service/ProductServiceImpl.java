package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Product;
import com.shop.exception.EmptyProductListException;
import com.shop.exception.IdNotFoundException;
import com.shop.exception.InvalidPriceException;
import com.shop.exception.NameNotFoundException;
import com.shop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		if(product.getPrice()<1) {
			throw new InvalidPriceException("Invalid Price(it should be non-zero positive value)");
		}
		return productRepository.save(product);
	}
	@Override
	public List<Product> displayAllProducts() {
		List<Product> pdt = productRepository.findAll();
		if(!pdt.isEmpty()) {
			return pdt;
		}else {
			throw new EmptyProductListException("No Products present");
		}
	}
	@Override
	public Product searchProductById(int id){
		Optional<Product> pdt = productRepository.findById(id);
		if(pdt.isPresent()) {
			return pdt.get();
		}else {
			throw new IdNotFoundException("Invalid Id input or Id not found"); 
		}
		//can also do this without checking or handling the exception
		//return productRepository.findById(id).get();  
	}
	@Override
	public List<Product> searchProductByName(String name) {
		List<Product> pdt = productRepository.findByName(name);
		if(!pdt.isEmpty()) {
			return pdt;
		}else {
			throw new NameNotFoundException("No Products present of this name");
		}
	}
	@Override
	public Product updateProduct(int id, Product product) {
		Optional<Product> pdt = productRepository.findById(id);
		if(pdt.isPresent()) {
			return productRepository.save(product);
		}else {
			throw new IdNotFoundException("Invalid Id input or Id not found");
		}
	}
	@Override
	public Product deleteProductById(int id) {
		Optional<Product> pdt = productRepository.findById(id);
		if(pdt.isPresent()) {
			productRepository.deleteById(id);
			System.out.println("Deleted Product");
			return pdt.get();
		}else {
			throw new IdNotFoundException("Invalid Id input or Id not found"); 
		}
	}
}
