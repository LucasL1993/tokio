package com.example.api.Exceptions;

public class CustomerNaoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = -4038932026079439828L;

	public CustomerNaoEncontradoException(Long id) {
		super("Customer com a id "+ id + " não foi encontrado");
	}

}
