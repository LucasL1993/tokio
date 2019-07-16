package com.example.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
	
	@Test
	public void testaGET() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/customers";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(url + "/1", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
}
