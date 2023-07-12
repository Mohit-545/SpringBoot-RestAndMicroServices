package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer				//to enable Eureka Server
public class BootMsProj01RandDServerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj01RandDServerEurekaApplication.class, args);
	}//main

}//class
