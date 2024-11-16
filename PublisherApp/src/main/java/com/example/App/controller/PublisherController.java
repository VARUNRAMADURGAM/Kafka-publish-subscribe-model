package com.example.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.App.dto.Customer;
import com.example.App.service.KafkaProducerService;

@RestController
@RequestMapping("/producer-app")
public class PublisherController {
	
	@Autowired
	private KafkaProducerService kafkaProducerService;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message){
		try {
			for(int i=0;i<=100000;i++) {
				kafkaProducerService.sendMessageTotopic(message +" "+ i);
			}
			
			return ResponseEntity.ok("message published successfully");
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/publish")
	public void sendEvents(@RequestBody Customer customer){
		kafkaProducerService.sendCustomerTotopic(customer);
	}
}
