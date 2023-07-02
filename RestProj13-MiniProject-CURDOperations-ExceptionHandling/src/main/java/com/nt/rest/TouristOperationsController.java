//TouristOperationsController.java
package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
			String msg = touristService.enrollTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}//method
	
	@GetMapping("/touristReport")
	public ResponseEntity<?> findAllTouristData(){
			List<Tourist> list = touristService.fetchAllTouristData();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
	}//method
	
	@GetMapping("/touristReport-ById/{id}")
	public ResponseEntity<?> findTouristInfoById(@PathVariable int id){
			Tourist tourist = touristService.fetchTouristInfoById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
	}//method
	
	@PutMapping("/update")
	public ResponseEntity<?> updateTouristDetails(@RequestBody Tourist tourist){
			String msg = touristService.updateTouristInfo(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	}//method
	
	@PatchMapping("/update/{id}/{hikePercentage}")
	public ResponseEntity<?> updateTouristById(@PathVariable int id,@PathVariable double hikePercentage){
			String msg = touristService.updateTouristInfoById(id, hikePercentage);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	}//method
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteTouristById(@PathVariable int id){
			String msg = touristService.deleteTouristById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	}//method

	@DeleteMapping("delete/{start}/{end}")
	public ResponseEntity<?> deleteTouristByBudget(@PathVariable double start, @PathVariable double end){
			String msg = touristService.deleteTouristByBudgetRange(start, end);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	}//method
	
}//class
