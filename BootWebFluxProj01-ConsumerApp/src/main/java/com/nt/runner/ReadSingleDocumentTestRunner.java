//ReadSingleDocumentTestRunner.java
package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Component
public class ReadSingleDocumentTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// creating web client object
		WebClient client = WebClient.create("http://localhost:4041");
		
		Mono<Employee> mono = client	
													.get()
													.uri("/employee/one/101")
													.retrieve()
													.bodyToMono(Employee.class);
													
			mono.subscribe(System.out::println);

	}//method

}//class
