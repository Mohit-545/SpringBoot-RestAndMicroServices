//UserController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.entity.UserDetails;
import com.nt.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/showLogin")
	public String showCustomLoginPage() {
		return "custom_login";
	}//method
	
	@GetMapping("/register")
	public String showUserRegistrationForm(@ModelAttribute("userInfo") UserDetails details) {
		return "user_register";
	}//method
	
	@PostMapping("/register")
	public String registerUser(Map<String, Object> map, @ModelAttribute("userInfo") UserDetails details) {
		String msg = userService.registerUser(details);
		map.put("resultMsg", msg);
		return "user_registered_success";
	}//method

}//class
