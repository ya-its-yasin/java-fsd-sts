package com.tcs.bootrestexceptions.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {NullPointerException.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(NullPointerException e, WebRequest req)
	{
		MyErrorResponse err = new MyErrorResponse();
		err.setMessage(e.getMessage());
		err.setErrorCode("406");
		err.setTime(new java.util.Date());
		
		return handleExceptionInternal(e, err, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, req);
	}
	
	@ExceptionHandler(value= InvalidValueException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(InvalidValueException e, WebRequest req)
	{
		MyErrorResponse err = new MyErrorResponse();
		err.setMessage(e.getMessage());
		err.setErrorCode("404");
		err.setTime(new java.util.Date());
		
		return handleExceptionInternal(e, err, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, req);
	}
	
	@ExceptionHandler(value= Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> errorHandler(Exception e, WebRequest req)
	{
		MyErrorResponse err = new MyErrorResponse();
		err.setMessage(e.getMessage());
		err.setErrorCode("404");
		err.setTime(new java.util.Date());
		
		return handleExceptionInternal(e, err, new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
	}
}
