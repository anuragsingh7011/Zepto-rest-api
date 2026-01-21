package com.zepto.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(UserAlreadyExistException.class)
	    public ResponseEntity<String> handleUserAlreadyExist(UserAlreadyExistException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	    }
	 @ExceptionHandler(InvalidLoginException.class)
	 public ResponseEntity<String>  handleInvalidLogin(InvalidLoginException ex){
		 return new ResponseEntity<String>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
	 }
	 
	@ExceptionHandler(Exception.class)
	public String exceptionGenric(Exception exception) {
//		model.addAttribute("error", "Unable to Process the Request" );
		return "Unable to Process the Request";
	}
}
