//BankOperationsController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}//method
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}//method
	
	@GetMapping("/balance")
	public String showBalance() {
		return "show_balance";
	}//method
	
	@GetMapping("/loan_approve")
	public String showLoanApproval() {
		return "loan_approve";
	}//method
	
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}//method

}//class
