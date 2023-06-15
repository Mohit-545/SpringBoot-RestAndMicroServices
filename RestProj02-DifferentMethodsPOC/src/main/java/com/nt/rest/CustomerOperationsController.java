//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerInfo")
public class CustomerOperationsController {
	
	@GetMapping("/report")
	public ResponseEntity<String> showCustomerInfo(){
		return new ResponseEntity<String>("From GET-ShowCustomerInfo() Method", HttpStatus.OK);
	}//method

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomerInfo(){
		return new ResponseEntity<String>("From POST-registerCustomerInfo() Method", HttpStatus.OK);
	}//method
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomerInfo(){
		return new ResponseEntity<String>("From PUT-updateCustomerInfo() Method", HttpStatus.OK);
	}//method
	
	@PatchMapping("/pmodify")
	public ResponseEntity<String> updateCustomerInfoByNo(){
		return new ResponseEntity<String>("From PATCH-updateCustomerInfoByNo() Method", HttpStatus.OK);
	}//method
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomerInfo(){
		return new ResponseEntity<String>("From DELETE-deleteCustomerInfo() Method", HttpStatus.OK);
	}//method

}//class
