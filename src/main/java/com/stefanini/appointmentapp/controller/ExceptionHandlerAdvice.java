package com.stefanini.appointmentapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(UnexpectedRollbackException.class)
    public ResponseEntity<?> handleSignUpException(UnexpectedRollbackException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Error Message");
    }

}
