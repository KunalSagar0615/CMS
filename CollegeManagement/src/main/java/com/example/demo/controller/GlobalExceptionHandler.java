package com.example.demo.controller;

import com.example.demo.exception.EmailMustBeUnique;
import com.example.demo.exception.IdMustBeUnique;
import com.example.demo.exception.InvalidDept;
import com.example.demo.exception.InvalidMob;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdMustBeUnique.class)
	public ResponseEntity<?> idMustBeUnique(IdMustBeUnique e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(EmailMustBeUnique.class)
	public ResponseEntity<?> emailMustBeUnique(EmailMustBeUnique e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(InvalidMob.class)
	public ResponseEntity<?> invalidMob(InvalidMob e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidDept.class)
	public ResponseEntity<?> InvalidDept(InvalidDept e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
