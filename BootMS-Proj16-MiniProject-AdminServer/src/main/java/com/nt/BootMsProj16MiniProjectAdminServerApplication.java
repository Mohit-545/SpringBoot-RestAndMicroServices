//BootMsProj16MiniProjectAdminServerApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class BootMsProj16MiniProjectAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj16MiniProjectAdminServerApplication.class, args);
	}//main

}//class
