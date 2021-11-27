package com.payment.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin()
@SpringBootApplication
public class SpringBootWebPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebPaymentApplication.class, args);
	}
	
	

}
