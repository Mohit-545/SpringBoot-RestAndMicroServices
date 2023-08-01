//BillingServiceController.java
package com.nt.rest;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nt.feign.IBillingServiceClient;

import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/billing")
@Slf4j
public class BillingServiceController {
	@Autowired
	private IBillingServiceClient clientComp;
	
	@GetMapping("/info")
	public ResponseEntity<String> getFinalGeneratedBillAmount(){
		log.info("At the begining of the getFinalGeneratedBillAmount() method - Billing-Service");
		double billAmt = new Random().nextDouble(10000.0);
		log.info("before calling provider MS");
		//use client comp to get the producer MS service instance from the Eureka server
		ResponseEntity<String> response = clientComp.getPaymentOptions();
		log.info("before calling provider MS");
		//generate the final result 
		String finalResult = "Final Bill Amount :: "+billAmt+" and the Payment Options are :: "+response.getBody();
		
		log.info("At the end of the getFinalGeneratedBillAmount() method - Billing-Service");
		return new ResponseEntity<String>(finalResult, HttpStatus.OK);
		
	}//method

}//class
