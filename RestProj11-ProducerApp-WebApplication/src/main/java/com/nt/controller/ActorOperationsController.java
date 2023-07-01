//ActorOperationsController.java
package com.nt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Actor;

@RestController
@RequestMapping("/actorapi")
public class ActorOperationsController {
	
	@GetMapping("/actor/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable String name){
		return new ResponseEntity<String>("Good Morning "+name, HttpStatus.OK);
	}//method
	
	@GetMapping("/actor/{id}/{name}")
	public ResponseEntity<String> displayWishMessageWithId(@PathVariable Integer id ,@PathVariable String name){
		return new ResponseEntity<String>("Good Morning "+name+" "+id, HttpStatus.OK);
	}//method
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>("Actor info :: "+actor.toString(), HttpStatus.CREATED);
	}//method
	
	@GetMapping("/report")
	public ResponseEntity<Actor> getActorData(){
		Actor actor = new Actor(50, "Aman", 30, "Madurai");
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}//method
	
	@GetMapping("/allReport")
	public ResponseEntity<List<Actor>> getAllActorData(){
		List<Actor> list = List.of(new Actor(1001, "Ishwar", 55, "Mumbai"), new Actor(1002, "Rohit", 38, "Puducherry"));
		return new ResponseEntity<List<Actor>>(list, HttpStatus.OK);
		
	}//method
}//class
