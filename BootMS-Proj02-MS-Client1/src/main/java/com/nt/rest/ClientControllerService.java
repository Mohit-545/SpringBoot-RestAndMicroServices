//ClientControllerService.java
package com.nt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class ClientControllerService {
	
	@GetMapping("/show")
	public String displayMessage() {
		return "Welcome to MicroServices Client";
	}//method

}//class
