//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")
public class CustomerOperationsController {
	@Value("${dbuser}")
	private String user;
	@Value("${dbpassword}")
	private String pass;
	
	@GetMapping("/show")
	public String displayMessage() {
		return "Customer Service data collected through ConfigServer :: "+user+"     "+pass;
	}//method

}//class
