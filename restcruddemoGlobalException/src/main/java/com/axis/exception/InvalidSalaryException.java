package com.axis.exception;

public class InvalidSalaryException extends RuntimeException{
	String msg;

	public InvalidSalaryException(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}	
}
