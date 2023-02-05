package com.shop.exception;

public class InvalidPriceException extends RuntimeException{

	String msg;

	public InvalidPriceException(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}	
}
