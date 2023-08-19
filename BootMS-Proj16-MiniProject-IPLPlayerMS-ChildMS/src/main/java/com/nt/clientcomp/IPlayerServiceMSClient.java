//IPlayerServiceMSClient.java
package com.nt.clientcomp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.entity.IPLTeam;

@FeignClient("IPL-TEAM-SERVICE")
public interface IPlayerServiceMSClient {
	
	@GetMapping("/IPLTeam-api/findTeam/{id}")
	public IPLTeam getTeamById(@PathVariable int id);

}//interface
