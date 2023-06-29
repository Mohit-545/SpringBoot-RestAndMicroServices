//ActorOperationsController.java
package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actorapi")
public class ActorOperationsController {
	
	@GetMapping("actor/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable String name){
		return new ResponseEntity<String>("Good Morning "+name, HttpStatus.OK);
	}//method

}//class
