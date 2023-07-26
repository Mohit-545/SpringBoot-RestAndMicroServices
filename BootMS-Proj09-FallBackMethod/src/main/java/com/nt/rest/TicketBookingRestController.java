//TicketBookingRestController.java
package com.nt.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingRestController {
	
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyMethod")
	public ResponseEntity<String> bookTickets(){
		System.out.println("TicketBookingRestController.bookTickets()");
		if(new Random().nextInt(10)<7) {
			throw new RuntimeException("Invalid Ticker Booking");
		}//if
		else
			return new ResponseEntity<String>("Tickets are booked...!!!!!!", HttpStatus.OK);
	}//method
	
	public ResponseEntity<String> dummyMethod(){
		System.out.println("TicketBookingRestController.dummyMethod()");
		return new ResponseEntity<String>("Please Try again later.....Some Internal Problem..!!!!!", HttpStatus.BAD_GATEWAY);
	}//method

}//class
