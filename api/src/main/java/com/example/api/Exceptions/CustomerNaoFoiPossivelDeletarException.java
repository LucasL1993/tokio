package com.example.api.Exceptions;

public class CustomerNaoFoiPossivelDeletarException extends RuntimeException{
	
	private static final long serialVersionUID = -8374141469056518235L;

	public CustomerNaoFoiPossivelDeletarException(Long id) {
		super("Não foi possivel deletar o objeto com a id "+ id);
	}
	
}