package com.example.api.dto;

import java.io.Serializable;

import com.example.api.domain.Customer;

public class CustomerDTO implements Serializable{

	private static final long serialVersionUID = 3500448238806151375L;
	
	private Long id;
	private String name;
	private String email;

	public Customer toObjeto() {
		return new Customer(id, name, email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
