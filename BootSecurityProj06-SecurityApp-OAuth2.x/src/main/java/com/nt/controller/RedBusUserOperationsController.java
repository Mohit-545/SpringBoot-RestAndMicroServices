//RedBusUserOperationsController.java
package com.nt.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedBusUserOperationsController {

	@GetMapping("/home")
	public String showHomePage() {
		return "<center><h1>Welcome to Red Bus Home Page</h1></center>";
	}//method
	
	@GetMapping("/after")
	public String afterLoginPage() {
		return "<center><h1>Hello, You have successfully logged into Red Bus</h1></center>";
	}//method
	
	@GetMapping("/user")
	public Authentication showUserDetails(Principal principal) {
		System.out.println("Logged In details :: "+principal.getName());
		// gives more info about the logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}//method
	
	
}//class
