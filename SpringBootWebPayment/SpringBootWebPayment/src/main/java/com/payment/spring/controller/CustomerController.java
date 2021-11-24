package com.payment.spring.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.spring.model.Customer;
import com.payment.spring.model.ResponsePage;
import com.payment.spring.service.CustomerService;


@RestController
@CrossOrigin()
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> findCustomers()
	{
		return this.customerService.getCustomers();
	}
	
	@GetMapping("/{customerid}")
	public ResponseEntity<Object> findCustomerById(@PathVariable String customerid)
	{
		try { 
			Customer cust = this.customerService.findCustomerById(customerid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(cust);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
}