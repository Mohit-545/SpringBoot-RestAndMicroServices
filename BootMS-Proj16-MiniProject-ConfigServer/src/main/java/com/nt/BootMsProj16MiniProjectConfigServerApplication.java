//BootMsProj16MiniProjectConfigServerApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj16MiniProjectConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj16MiniProjectConfigServerApplication.class, args);
	}//main

}//class
