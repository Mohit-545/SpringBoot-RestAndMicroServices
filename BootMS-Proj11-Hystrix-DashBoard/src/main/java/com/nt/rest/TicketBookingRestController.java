//TicketBookingRestController.java
package com.nt.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingRestController {
	int count=0;
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyMethod",
										commandProperties = {
												@HystrixProperty(name="circuitBreaker.enabled", value = "true"),
												@HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "5"),
												@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000")})
	public ResponseEntity<String> bookTickets(){
		System.out.println("TicketBookingRestController.bookTickets()");
		if(new Random().nextInt(10)<5) {
			throw new RuntimeException("Invalid Ticker Booking");
		}//if
		else
			return new ResponseEntity<String>("Tickets are booked...!!!!!!", HttpStatus.OK);
	}//method
	
	public ResponseEntity<String> dummyMethod(){
		count++;
		System.out.println("TicketBookingRestController.dummyMethod()::count:::"+count);
		return new ResponseEntity<String>("Please Try again later.....Some Internal Problem..!!!!!", HttpStatus.BAD_GATEWAY);
	}//method

}//class
