//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {
	
	/*@GetMapping("/register")
	public String register(@RequestParam Integer cno, @RequestParam String cname){
		return "cno="+cno+"\ncname="+cname;
	}//method
	*/
	
	@GetMapping("/register")
	public String register(@RequestParam Integer cno, @RequestParam(required = true, defaultValue = "Akash") String cname){
		return "cno="+cno+"\ncname="+cname;
	}//method
	
}//class
