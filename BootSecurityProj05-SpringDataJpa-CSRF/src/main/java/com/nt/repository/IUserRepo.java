//UserDetails.java
package com.nt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.UserDetails;

public interface IUserRepo extends CrudRepository<UserDetails, Integer> {
	
	public Optional<UserDetails> findUserByUname(String uname);

}//interface
