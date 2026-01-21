package com.zepto.user.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistException.class)
	public String businessException(EmailAlreadyExistException exception) {
//		model.addAttribute("error", "Email Already exist" );
		return "Email Already exist " + exception.getMessage();
	}

	@ExceptionHandler(Exception.class)
	public String exceptionGenric(Exception exception) {
//		model.addAttribute("error", "Unable to Process the Request" );
		return "Unable to Process the Request";
	}
}
