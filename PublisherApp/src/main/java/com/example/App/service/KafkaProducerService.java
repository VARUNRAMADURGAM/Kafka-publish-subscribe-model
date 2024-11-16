package com.example.App.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.example.App.dto.Customer;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate; 

	public void sendMessageTotopic(String message) {
		ListenableFuture<SendResult<String, Object>> future1 = kafkaTemplate.send("demo5", message); 
																										
																										
		CompletableFuture<SendResult<String, Object>> future = future1.completable();
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("success");
			} else {
				System.out.println("failure");
			}
		});
	}
	
	public void sendCustomerTotopic(Customer customer) {
		System.out.println("Customer [id=" + customer.getId() + ", name=" + customer.getName() + ", email=" + customer.getEmail() + ", number=" + customer.getNumber() + "]");
		try {
		ListenableFuture<SendResult<String, Object>> future1 = kafkaTemplate.send("customer-demo", customer); 
																										
																										
		CompletableFuture<SendResult<String, Object>> future = future1.completable();
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("success");
			} else {
				System.out.println("failure");
			}
		});
	}catch(Exception ex) {
		System.out.println("ERROR"+ ex.getMessage());
	}
	}
}
