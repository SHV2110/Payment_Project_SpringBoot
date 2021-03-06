package com.payment.spring.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.spring.model.Customer;
import com.payment.spring.service.CustomerService;


@RestController
@CrossOrigin()
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping
	public List<Customer> findCustomers()
	{
		return this.customerService.getCustomers();
	}
	
	
	//custid
	@GetMapping("/{customerID}")
	public Customer getC(@PathVariable(name="customerID") String c) {
	LOG.info("customerID verification");
	return customerService.getCustomerDetails(c);
	}
	
	@GetMapping("name-check/{name}")
	public boolean checkName(@PathVariable(name="name") String name) throws IOException {
	LOG.info("Name Verification");
	return customerService.checkName(name);

	}
}