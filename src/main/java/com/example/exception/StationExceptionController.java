package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StationExceptionController {
	@ExceptionHandler(value = StationNotFoundException.class)
	 public ResponseEntity<Object> exception(StationNotFoundException exception) {
	      return new ResponseEntity<>("Station not found", HttpStatus.NOT_FOUND);
	   }
}
