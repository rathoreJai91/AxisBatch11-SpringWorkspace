package com.shop.exception;

public class NameNotFoundException extends RuntimeException{

	String msg;

	public NameNotFoundException(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
