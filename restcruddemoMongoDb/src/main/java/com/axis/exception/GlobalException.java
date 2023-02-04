package com.axis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(IdNotFoundException.class)
    ResponseEntity<String> idException(IdNotFoundException exception){
		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InvalidAgeException.class)
    ResponseEntity<String> ageException(InvalidAgeException exception){
		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InvalidSalaryException.class)
    ResponseEntity<String> salaryException(InvalidSalaryException exception){
		return new ResponseEntity<String>(exception.getMsg(), HttpStatus.NOT_FOUND);
    }
	
}
