//IPLPlayerMgmtServiceImpl.java
package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLPlayer;
import com.nt.repository.IPLPlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service("IPLPlayerService")
@Slf4j
public class IPLPlayerMgmtServiceImpl implements IPLPlayerMgmtService {
	
	@Autowired
	private IPLPlayerRepository playerRepo;

	@Override
	public String registerIPLPlayer(IPLPlayer player) {
		log.info("service - registerIPLPlayer() method executed");
		int id = playerRepo.save(player).getPid();
		return "IPL Player is saved with id :: "+id;
	}//method

	@Override
	public List<IPLPlayer> findAllIPLPlayer() {
		log.info("service - findAllPlayer() method executed");
		return playerRepo.findAll();
	}//method

	@Override
	public IPLPlayer findIPLPlayerById(int playerId) {
		log.info("service - findIPLPlayerById() method executed");
		Optional<IPLPlayer> opt = playerRepo.findById(playerId);
		if(opt.isPresent()) {
			log.info("service - findIPLPlayerById :: Player found and returned ");
			return opt.get();
		}//if
		log.error("Problem in finding the Player");
		throw new IllegalArgumentException("Player Not Found......!!!!!");
	}//method
	


}//class
