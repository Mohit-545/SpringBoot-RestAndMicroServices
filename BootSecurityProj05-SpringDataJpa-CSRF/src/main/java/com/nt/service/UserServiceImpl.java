//IUserServiceImpl.java
package com.nt.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.repository.IUserRepo;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private IUserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// getting model class object
		Optional<com.nt.entity.UserDetails> opt = userRepo.findUserByUname(username);
		if(opt.isEmpty()) {
			throw new IllegalArgumentException("User Not Found...!!!!!");
		}//if
		else {
			com.nt.entity.UserDetails details = opt.get();
			User user = new User(details.getUname(), details.getPwd(), 
														details.getRoles().stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			return user;
		}//else
	}//method

	@Override
	public String registerUser(com.nt.entity.UserDetails user) {
		user.setPwd(encoder.encode(user.getPwd()));
		return "User is registered with user Id :: "+userRepo.save(user).getUnid();
	}//method

}//class
