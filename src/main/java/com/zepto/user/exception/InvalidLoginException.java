package com.zepto.user.exception;


public class InvalidLoginException extends RuntimeException{

	public InvalidLoginException(String msg) {
		super(msg);
	}
	
}
