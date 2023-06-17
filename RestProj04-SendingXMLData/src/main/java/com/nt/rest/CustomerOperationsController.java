//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
@RequestMapping("/custOperations")
public class CustomerOperationsController {
	
	@GetMapping("/custReport")
	public ResponseEntity<Customer> showCustomerData(){
		Customer cust = new Customer(1001, "Ramesh Rai", "Chennai", 85000.0);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}//method

}//class
