package com.example.api.domain.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.api.Exceptions.CustomerNaoEncontradoException;

@ControllerAdvice
public class CustomerNaoEncontradoAdvice {
	
@ResponseBody
@ExceptionHandler(CustomerNaoEncontradoException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(CustomerNaoEncontradoException cex) {
		return cex.getMessage();
	}
	
}
