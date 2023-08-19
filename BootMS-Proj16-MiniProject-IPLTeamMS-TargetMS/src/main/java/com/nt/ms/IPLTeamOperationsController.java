//IPLTeamOperationsController.java
package com.nt.ms;

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

import com.nt.entity.IPLTeam;
import com.nt.service.IPLTeamMgmtServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/IPLTeam-api")
@Slf4j
public class IPLTeamOperationsController {
	@Autowired
	private IPLTeamMgmtServiceImpl teamService;
	
	@PostMapping("/registerTeam")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		log.info("controller - register Team method() START");
		//using Service to register
		try {
			String resultMsg = teamService.registerIPLTeam(team);
			log.info("controller - register Team method() :: executed sucessfully");
			log.info("controller - register Team method() END");
			return new ResponseEntity<String>(resultMsg, HttpStatus.CREATED);
		}//try
		catch (Exception e) {
			log.error("controller - Problem in register Team method() :: "+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
		
	}//method
	
	@GetMapping("/allTeams")
	public ResponseEntity<?> showAllTeams(){
		log.info("controller - showAllTeams method() START");
		//use Service to all teams info
		try {
			List<IPLTeam> list = teamService.getAllTeams();
			log.info("controller - showAllTeams method() :: executed successfully");
			log.info("controller - showAllTeams method() END");
			return new ResponseEntity<List<IPLTeam>>(list, HttpStatus.OK);
		}//try
		catch (Exception e) {
			log.error("controller - Problem in showAllTeams method() :: "+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	
	@GetMapping("/findTeam/{id}")
	public ResponseEntity<?> showTeamById(@PathVariable int id){
		log.info("controller - showTeamById method() START");
		//use Service to get team info by id
		try {
			IPLTeam team = teamService.getTeamById(id);
			log.info("controller - showTeamById method() :: executed successfully");
			log.info("controller - showTeamById method() END");
			return new ResponseEntity<IPLTeam>(team, HttpStatus.OK);
		}//try
		catch (Exception e) {
			log.error("controller - Problem in showTeamById method() :: "+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method

}//class
