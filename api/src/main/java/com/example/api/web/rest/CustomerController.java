package com.example.api.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Exceptions.CustomerNaoEncontradoException;
import com.example.api.domain.Customer;
import com.example.api.dto.CustomerDTO;
import com.example.api.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public List<Customer> findAll() {
			return service.findAll();
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new CustomerNaoEncontradoException(id));
	}
	
	
	@PostMapping(path = "/cadastrar", consumes = "application/json")
	public ResponseEntity<Customer> salvar(@RequestBody CustomerDTO customerDTO, BindingResult result) {
		
		if (result.hasErrors()) {
			return (ResponseEntity<Customer>) ResponseEntity.badRequest();
		}
		Customer customer = service.save(customerDTO.toObjeto());
	    return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
	
	 @PutMapping("/{id}")
	 public Customer atualizaCustomer(@RequestBody Customer atualizaCustomer, @PathVariable Long id) {

	    return service.findById(id)
	      .map(customer -> {
	    	  customer.setName(atualizaCustomer.getName());
	    	  customer.setEmail(atualizaCustomer.getEmail());
	        return service.save(customer);
	      })
	      .orElseGet(() -> {
	    	  atualizaCustomer.setId(id);
	        return service.save(atualizaCustomer);
	      });
	  }

	  @DeleteMapping("/{id}")
	  void deleteEmployee(@PathVariable Long id) {
		service.findById(id);
	    service.delete(id);
	  }
	
}
