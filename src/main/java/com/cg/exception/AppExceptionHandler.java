package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Exception Handler
@ControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler({ ApplicationException.class })
	public ResponseEntity<String> handleError(ApplicationException exception) {
		System.out.println("Exception Handled");
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);

	}
}
