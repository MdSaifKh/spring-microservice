package com.mind.address.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mind.address.exceptions.AddressNotFoundException;

@ControllerAdvice
public class AddressExceptionHandler {
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<String> AddressNotFoundExceptionHandler(AddressNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

}
