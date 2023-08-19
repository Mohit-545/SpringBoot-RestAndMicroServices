//IPLPlayerOperationsController.java
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

import com.nt.clientcomp.IPlayerServiceMSClient;
import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IPLPlayerMgmtServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player-api")
@Slf4j
public class IPLPlayerOperationsController {
	
	@Autowired
	private IPLPlayerMgmtServiceImpl playerService;
	@Autowired
	private IPlayerServiceMSClient client;
	
	@PostMapping("/registerPlayer")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		log.info("controller - registerPlayer() method START");
		//get Player's Team id
		int tid = player.getTeam().getTeamId();
		//get IPLTeam object from TargetMS
		IPLTeam team = client.getTeamById(tid);
		//set Team object to Player object
		player.setTeam(team);
		try {
			//use Service to register player info
			String msg = playerService.registerIPLPlayer(player);
			log.info("controller - registerPlayer() method - executed successfully");
			log.info("controller - registerPlayer() method END");
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}//try
		catch (Exception e) {
			log.error("Problem in registering Player :: "+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	
	@GetMapping("/allPlayers")
	public ResponseEntity<?> showAllPlayers(){
		log.info("controller - showAllPlayers() method START");
		try {
			List<IPLPlayer> list = playerService.findAllIPLPlayer();
			log.info("controller - showAllPlayers() method - successfully executed");
			log.info("controller - showAllPlayers() method END");
			return new ResponseEntity<List<IPLPlayer>>(list, HttpStatus.OK);
		}//try
		catch (Exception e) {
			log.error("controller -  Problem in showAllPlayer() method :: "+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method
	
	@GetMapping("/findPlayer/{id}")
	public ResponseEntity<?> showPlayerById(@PathVariable int id){
		log.info("controller - showPlayerById() method START");
		try {
			IPLPlayer player = playerService.findIPLPlayerById(id);
			log.info("controller - showPlayerById() method successfully executed");
			log.info("controller - showPlayerById() method END");
			return new ResponseEntity<IPLPlayer>(player, HttpStatus.OK);
		}//try
		catch (Exception e) {
			log.error("controller - Problem in showPlayerById() method :: "+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}//catch
	}//method

}//class
