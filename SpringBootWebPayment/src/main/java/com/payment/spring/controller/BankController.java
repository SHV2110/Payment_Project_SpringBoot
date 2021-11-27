package com.payment.spring.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.spring.model.Bank;
import com.payment.spring.service.BankService;

@RestController
@CrossOrigin("*")
@RequestMapping("/bank")    
public class BankController {
	@Autowired
	private BankService bankService;
	private static final Logger LOG = LoggerFactory.getLogger(BankController.class);
	@GetMapping("/{bic}")
	public Bank getRecieverBIC(@PathVariable(name="bic") String bic) {
	LOG.info("bank id verification");
	return bankService.getRecieverDetails(bic);
}}