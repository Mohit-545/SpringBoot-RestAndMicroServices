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

@RestController()
@RequestMapping("/billing")
public class BillingServiceController {
	@Autowired
	private IBillingServiceClient clientComp;
	
	@GetMapping("/info")
	public ResponseEntity<String> getFinalGeneratedBillAmount(){
		int billAmt = new Random().nextInt(10000);
		//use client comp to get the producer MS service instance from the Eureka server
		ResponseEntity<String> response = clientComp.getPaymentOptions();
		//generate the final result 
		String finalResult = "Final Bill Amount :: "+billAmt+" and the Payment Options are :: "+response.getBody();
		
		return new ResponseEntity<String>(finalResult, HttpStatus.OK);
		
	}//method

}//class
