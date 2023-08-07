//PaymentServiceController.java
package com.nt.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentServiceController {
	
	@GetMapping("/billing")
	public ResponseEntity<String> doPayment(){
		log.info("At the begining of the doPayment()-method");
		int amt = new Random().nextInt(10000);
		log.info("Bill Amount is generated");
		if(amt<7000){
			try {
				log.error("Problem in generated bill amount");
				throw new RuntimeException("Invalid payment method");
			}//try
			catch (Exception e) {
				log.error("Problem in generated bill amount :: "+e.getMessage());
				return new ResponseEntity<String>("Problem in generated bill amount :: ", HttpStatus.INTERNAL_SERVER_ERROR);
			}//catch
		}//if
		else {
			log.info("Bill Amount is sucessfully sent to Client Application");
			return new ResponseEntity<String>("Final Bill Amount :: "+amt, HttpStatus.OK);
		}//else
	}//method

}//class
