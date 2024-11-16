package com.example.App.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.App.dto.Customer;

@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics = "customer-demo",groupId = "kafka-consumer-3")
	public void consume(Customer customer) {
		System.out.println("Customer [id=" + customer.getId() + ", name=" + customer.getName() + ", email=" + customer.getEmail() + ", number=" + customer.getNumber() + "]");
	}
	
	/* to implement multiple consumer instances below code is for demo purpose only */
//	@KafkaListener(topics = "demo5",groupId = "kafka-consumer-2")
//	public void consume2(String message) {
//		System.out.println("Consumed message by 2"+ message);
//	}
//	
//	@KafkaListener(topics = "demo5",groupId = "kafka-consumer-2")
//	public void consume3(String message) {
//		System.out.println("Consumed message by 3"+ message);
//	}
//	
//	@KafkaListener(topics = "demo5",groupId = "kafka-consumer-2")
//	public void consume4(String message) {
//		System.out.println("Consumed message by 4"+ message);
//	}
//	
//	@KafkaListener(topics = "demo5",groupId = "kafka-consumer-2")
//	public void consume5(String message) {
//		System.out.println("Consumed message by 5"+ message);
//	}
//	
//	@KafkaListener(topics = "demo5",groupId = "kafka-consumer-2")
//	public void consume6(String message) {
//		System.out.println("Consumed message by 6"+ message);
//	}
}
