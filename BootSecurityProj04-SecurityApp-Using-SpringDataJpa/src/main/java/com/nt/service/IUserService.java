//IUserService.java
package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.entity.UserDetails;

public interface IUserService extends UserDetailsService {
	
	public String registerUser(UserDetails user);

}//interface
