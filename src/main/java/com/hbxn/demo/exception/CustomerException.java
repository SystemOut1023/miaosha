package com.hbxn.demo.exception;

/**
 * @author SQiang
 * @create 2018-05-18 9:06
 **/
public class CustomerException extends RuntimeException {
	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}
}
