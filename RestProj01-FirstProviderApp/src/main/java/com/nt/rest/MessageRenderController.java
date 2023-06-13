//MessageRenderController.java
package com.nt.rest;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageapi") 	//global path
public class MessageRenderController {
	
	@GetMapping("/wish") //method path
	public ResponseEntity<String> showMessage(){
		//get System date and time
		LocalDateTime ldt = LocalDateTime.now();
		//get current hour
		int hour = ldt.getHour();
		// b.logic (sample)
		String msg = null;
		if(hour<12)
			msg = "Good Morning";
		else if(hour<16)
			msg = "Good Afternoon";
		else if(hour<20)
			msg = "Good Evening";
		else 
			msg = "Good Night";
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}//method

	@GetMapping("/age")
	public ResponseEntity<Map<String, Integer>> showAge(){
		Map<String,Integer> map = Map.of("Tarun", 26, "Akash", 25, "Paresh", 30);
		return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
	}//method
	
}//class
