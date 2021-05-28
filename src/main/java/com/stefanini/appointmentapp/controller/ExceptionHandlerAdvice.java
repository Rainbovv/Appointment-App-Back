package com.stefanini.appointmentapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
	
	@ExceptionHandler(UnexpectedRollbackException.class)
    public ResponseEntity<?> handleSignUpException(UnexpectedRollbackException e) {
        logger.info("LOG FROM CONTROLLER ADVICE!");
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Error Message");
    }

}
