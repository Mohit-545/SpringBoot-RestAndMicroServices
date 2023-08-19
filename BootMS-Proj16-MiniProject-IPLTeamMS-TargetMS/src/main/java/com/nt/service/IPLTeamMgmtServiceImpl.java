//IPLTeamMgmtServiceImpl.java
package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLTeam;
import com.nt.repository.IPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service("IPLTeamService")
@Slf4j
public class IPLTeamMgmtServiceImpl implements IPLTeamMgmtService {

	@Autowired
	private IPLTeamRepository teamRepo;
	
	@Override
	public String registerIPLTeam(IPLTeam team) {
		log.info("service - register IPLTeam method() :: executed");
		 int id = teamRepo.save(team).getTeamId();
		return "IPL Team is saved with id :: "+id;
	}//method

	@Override
	public List<IPLTeam> getAllTeams() {
		log.info("service - getAllTeam method() :: executed");
		return teamRepo.findAll();
	}//method

	@Override
	public IPLTeam getTeamById(int teamId) {
		log.info("service - getTeamById method() :: executed");
		return teamRepo.findById(teamId).orElseThrow(()-> new IllegalArgumentException("Invalid Team Id...!!!!!"));
	}//method

}//class
