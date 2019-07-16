package com.example.api.Exceptions;

public class CustomerNaoFoiPossivelCadastrarException extends RuntimeException{
	
	private static final long serialVersionUID = -8374141469056518235L;

	public CustomerNaoFoiPossivelCadastrarException(Long id) {
		super("Não foi possivel concluir a transação do objeto com a id "+ id);
	}
}
