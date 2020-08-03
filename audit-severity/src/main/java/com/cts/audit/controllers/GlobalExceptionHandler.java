package com.cts.audit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cts.audit.exception.FeignServiceException;
import com.cts.audit.exception.RequestInvalidException;
import com.cts.audit.exception.TokenInvalidException;

import feign.FeignException;

@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(FeignServiceException.class)
public ResponseEntity<FeignServiceException> handleFeignErrors(final FeignServiceException e){
	ResponseEntity<FeignServiceException> response=new ResponseEntity<FeignServiceException>(HttpStatus.FAILED_DEPENDENCY);
	return response;
}

@ExceptionHandler(RequestInvalidException.class)
public ResponseEntity<RequestInvalidException> handleInvalidRequests(final RequestInvalidException e){
	return new ResponseEntity<RequestInvalidException>(HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(TokenInvalidException.class)
public ResponseEntity<TokenInvalidException> handleInvalidTokens(final TokenInvalidException e){
	return new ResponseEntity<TokenInvalidException>(HttpStatus.FORBIDDEN);
}
@ExceptionHandler(FeignException.class)
public ResponseEntity<FeignException> handlingServiceDown(final FeignException e){
	return new ResponseEntity<FeignException>(HttpStatus.valueOf(e.status()));
}


}
