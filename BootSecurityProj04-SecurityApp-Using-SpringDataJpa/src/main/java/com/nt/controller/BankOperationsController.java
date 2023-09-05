//BankOperationsController.java
package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
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
	public String showBalance(Map<String, Object> map) {
		map.put("balance", new Random().nextInt(1000000));
		return "show_balance";
	}//method
	
	@GetMapping("/loan_approve")
	public String showLoanApproval(Map<String, Object> map) {
		map.put("amt", new Random().nextInt(1000000));
		return "loan_approve";
	}//method
	
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}//method

}//class
