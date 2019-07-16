package com.example.api.domain.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.api.Exceptions.CustomerNaoFoiPossivelDeletarException;

public class CustomerNaoFoiPossivelDeletarAdvice {
	@ResponseBody
	@ExceptionHandler(CustomerNaoFoiPossivelDeletarException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		String employeeNotFoundHandler(CustomerNaoFoiPossivelDeletarException cex) {
			return cex.getMessage();
		}

}
