//EmployeeServiceController.java
package com.nt.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeServiceController {

	public String displayMessage() {
		return "welcome to Spring Boot Actuators - Employee Service";
	}//method
	
}//class
