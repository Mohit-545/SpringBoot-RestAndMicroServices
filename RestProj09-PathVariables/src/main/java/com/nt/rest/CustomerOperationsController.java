//CustomerOperationsController.java
package com.nt.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {
	
	@PostMapping("/register/{cno}/{cname}")
	public String register(@PathVariable Integer cno, @PathVariable String cname){
		return "cno="+cno+"\ncname="+cname;
	}//method
	
}//class
