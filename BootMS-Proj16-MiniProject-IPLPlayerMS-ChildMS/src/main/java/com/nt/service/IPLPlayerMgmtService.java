//IPLPlayerMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.IPLPlayer;

public interface IPLPlayerMgmtService {
	// register player method
	public String registerIPLPlayer(IPLPlayer player);
	
	//find all player method
	public List<IPLPlayer> findAllIPLPlayer();
	
	//find player by id method
	public IPLPlayer findIPLPlayerById(int playerId);

}//interface
