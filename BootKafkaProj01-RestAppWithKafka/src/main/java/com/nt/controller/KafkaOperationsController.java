//KafkaOperationsController.java
package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.consumer.MessageStore;
import com.nt.producer.MessageProducer;

@RestController
public class KafkaOperationsController {
	@Autowired
	private MessageProducer producer;
	@Autowired
	private MessageStore store;
	
	@GetMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam String message){
		//send the message
		String resultMsg = producer.sendMessage(message);
		return new ResponseEntity<String>("<center><h1>"+resultMsg+"</h1></center>", HttpStatus.OK);
	}//method
	
	@GetMapping("/readAll")
	public ResponseEntity<List<String>> showAllMessages(){
		List<String> list = store.getAllMessages();
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}//method

}//class
