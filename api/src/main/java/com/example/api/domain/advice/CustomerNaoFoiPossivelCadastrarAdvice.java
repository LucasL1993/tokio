package com.example.api.domain.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.api.Exceptions.CustomerNaoFoiPossivelCadastrarException;

@ControllerAdvice
public class CustomerNaoFoiPossivelCadastrarAdvice {
	
	@ResponseBody
	@ExceptionHandler(CustomerNaoFoiPossivelCadastrarException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		String employeeNotFoundHandler(CustomerNaoFoiPossivelCadastrarException cex) {
			return cex.getMessage();
		}

}


	