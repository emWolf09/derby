package com.derby.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.derby.exception.CustomException;

@ControllerAdvice
public class ProfileExceptionAdvice{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomException> handleParent(Exception exception){
		CustomException customException = new CustomException();
		exception.printStackTrace();
		customException.setMessage(exception.getMessage());
		return new ResponseEntity<CustomException>(customException,HttpStatus.NOT_FOUND);	
	}
}
