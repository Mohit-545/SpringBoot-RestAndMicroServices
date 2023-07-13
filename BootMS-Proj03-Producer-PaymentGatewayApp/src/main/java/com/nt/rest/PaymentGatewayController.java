//PaymentGatewayController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentGatewayController {
	
	@GetMapping("/options")
	public ResponseEntity<String> paymentOptions(){
		return new ResponseEntity<String>(" GPay or PhonePay or NetBanking or Debit Card or Credit Card",															
																			HttpStatus.OK);
	}//method

}//class
