package com.payment.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.spring.model.Message;



public interface MessageRepository extends JpaRepository<Message,String> {

}
