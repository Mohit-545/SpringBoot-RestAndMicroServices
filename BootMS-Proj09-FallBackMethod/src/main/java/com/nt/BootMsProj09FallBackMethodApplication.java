package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class BootMsProj09FallBackMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj09FallBackMethodApplication.class, args);
	}

}
