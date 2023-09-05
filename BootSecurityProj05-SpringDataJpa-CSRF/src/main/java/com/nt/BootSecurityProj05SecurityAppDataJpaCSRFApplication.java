package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BootSecurityProj05SecurityAppDataJpaCSRFApplication {
	
	@Bean
	public BCryptPasswordEncoder registerEncoder() {
		return new BCryptPasswordEncoder();
	}//method

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityProj05SecurityAppDataJpaCSRFApplication.class, args);
	}//main

}//class
