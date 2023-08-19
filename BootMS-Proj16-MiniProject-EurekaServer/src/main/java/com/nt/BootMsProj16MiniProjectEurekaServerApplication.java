//BootMsProj16MiniProjectEurekaServerApplication.java (main class)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj16MiniProjectEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj16MiniProjectEurekaServerApplication.class, args);
	}//main

}//class
