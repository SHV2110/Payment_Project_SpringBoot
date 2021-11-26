package com.payment.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.spring.model.Transaction;
import com.payment.spring.service.TransactionService;


@RestController
@CrossOrigin()
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public List<Transaction> getAllTransactions() {
		return this.transactionService.getAllTransactions();
	}
	
	@PostMapping
	public ResponseEntity<Object> insertTransaction(@RequestBody Transaction transaction) {
		if (this.transactionService.insertTransaction(transaction)) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("Transaction inserted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Transaction Failed");
		}
	}
	
}