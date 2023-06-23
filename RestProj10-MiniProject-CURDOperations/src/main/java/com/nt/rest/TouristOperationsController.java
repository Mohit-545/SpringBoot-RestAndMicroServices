//TouristOperationsController.java
package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristMgmtService;

@RestController
@RequestMapping("/touristapi")
public class TouristOperationsController {
	@Autowired
	private ITouristMgmtService touristService;
	
	@PostMapping("/register-tourist")
	public ResponseEntity<String> enrollNewTourist(@RequestBody Tourist tourist){
		try {
			String msg = touristService.enrollTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}//try
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method

}//class
