//IPLTeamMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.IPLTeam;

public interface IPLTeamMgmtService {
	//to register the Team
	public String registerIPLTeam(IPLTeam team);
	
	//to get all the Teams info 
	public List<IPLTeam> getAllTeams();
	
	//to get Teams info by id
	public IPLTeam getTeamById(int teamId);

}//interface
