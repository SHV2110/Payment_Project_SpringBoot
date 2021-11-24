package com.payment.spring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.spring.model.Customer;
import com.payment.spring.model.Transaction;
import com.payment.spring.repository.TransactionRepository;
@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private CustomerService customerService;
	private static final Logger LOG = LoggerFactory.getLogger(TransactionService.class);
	SdnChecker sdn = new SdnChecker();
	
	public List<Transaction> getAllTransactions(){
		List<Transaction> t = new ArrayList<Transaction>();
		t = this.transactionRepository.findAll();
		return t;
		
	}
	
	public boolean insertTransaction(Transaction transaction) {
		LOG.info("insertTransaction");
		
		if (this.transactionRepository.findById(transaction.getTransactionid()).isPresent()) {
			return false;
		}
		else {
			SdnChecker sdn = new SdnChecker();
			
			try {
				if(sdn.checker(transaction.getReceiveraccountholdername())) {
					Customer c = transaction.getCustomerid();// parameter for sendmoney of custservice method
					double ammount = transaction.getamount()+ (transaction.getamount() * 0.0025);//ammount para for send menoy method
						if(customerService.sendMoney(c, ammount))
						{
							transaction.setTransferfees(transaction.getamount()*0.0025);
							transaction.setTransferdate(LocalDate.now());
							this.transactionRepository.save(transaction);
							return true;
						}
						
						else {
							return false;
						}
				}
				else {
					System.out.println("The Receiver "+transaction.getReceiveraccountholdername()+"is in SDN List"  );	
					}
				return false;
			}
			catch(Exception e){
				e.printStackTrace();	
			}
		}
		
		return false;
		
	}

}
