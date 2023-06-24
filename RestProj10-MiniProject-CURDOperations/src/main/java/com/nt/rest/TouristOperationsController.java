//TouristOperationsController.java
package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/touristReport")
	public ResponseEntity<?> findAllTouristData(){
		try {
			List<Tourist> list = touristService.fetchAllTouristData();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		}//try
		catch(RuntimeException re) {
			return new ResponseEntity<String>(re.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	
	@GetMapping("/touristReport-ById/{id}")
	public ResponseEntity<?> findTouristInfoById(@PathVariable int id){
		try {
			Tourist tourist = touristService.fetchTouristInfoById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		}//try
		catch(RuntimeException re) {
			return new ResponseEntity<String>(re.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
}//class
