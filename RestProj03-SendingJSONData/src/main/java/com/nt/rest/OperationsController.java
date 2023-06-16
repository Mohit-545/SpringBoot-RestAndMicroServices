//OperationsController.java
package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;
import com.nt.model.Employee;

@RestController
@RequestMapping("/info")
public class OperationsController {

	@GetMapping("/empInfo")
	public ResponseEntity<Employee> showEmployeeData(){
		Employee emp = new Employee(1001, "Mayank", "Accounting", 35000.0);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}//method
	
	@GetMapping("/custInfo")
	public ResponseEntity<Customer> showCustomerInfo(){
		Customer cust = new Customer(1100, "Akash Choudhary", 60000.0, new String[] {"purple,white,maroon"}
																		,List.of("Core Java", "Adv Java", "SpringBoot")
																		,Set.of(8888985957L, 9855664433L)
																		, Map.of("Aadhar No", 9885475836581457L,"Pan Card",845697725L)
																		, new Company("TCS", "Bengaluru", "IT Services", 5000));
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}//method
	
}//class
