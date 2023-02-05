package com.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<String> idException(IdNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NameNotFoundException.class)
	ResponseEntity<String> nameException(NameNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidPriceException.class)
	ResponseEntity<String> priceException(InvalidPriceException exception) {
		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyProductListException.class)
	ResponseEntity<String> productListException(EmptyProductListException exception) {
		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
	}
}
