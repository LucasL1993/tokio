package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.Exceptions.CustomerNaoEncontradoException;
import com.example.api.Exceptions.CustomerNaoFoiPossivelCadastrarException;
import com.example.api.Exceptions.CustomerNaoFoiPossivelDeletarException;
import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Long id) {
		try {
			return repository.findById(id);
		} catch (CustomerNaoEncontradoException e) {
			throw new CustomerNaoEncontradoException(id);
		}
	}

	public Customer save(Customer c) {
		try {
			return repository.save(c);
		} catch (Exception e) {
			System.out.println("aqui um log para informar porque deu o erro " + e);
			throw new CustomerNaoFoiPossivelCadastrarException(c.getId());
		}
	}

	public void delete(Long id) {
		// Normalmente se inativa mas irei deletar :D
		try {
		 repository.deleteById(id);
		 
		} catch (Exception e) {
			System.out.println("aqui um log para informar porque deu o erro " + e);
			throw new CustomerNaoFoiPossivelDeletarException(id);
		}
	}

}
