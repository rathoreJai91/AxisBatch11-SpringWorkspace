package com.shop.exception;

public class EmptyProductListException extends RuntimeException{

	String msg;
	public EmptyProductListException(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
}
