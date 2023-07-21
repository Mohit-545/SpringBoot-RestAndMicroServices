//EmployeeOperationsController.java
package com.nt.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
@RefreshScope
public class EmployeeOperationsController {
	@Value("${dbuser}")
	private String user;
	@Value("${dbpassword}")
	private String pass;
	
	@GetMapping("/show")
	public ResponseEntity<String> displayMessage() {
		return new ResponseEntity<String> ("Employee Service data collected through ConfigServer :: "+user+"     "+pass , HttpStatus.OK);
	}//method

}//class
