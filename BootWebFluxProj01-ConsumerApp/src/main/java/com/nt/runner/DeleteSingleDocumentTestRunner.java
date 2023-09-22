//DeleteSingleDocumentTestRunner.java
package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.nt.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@Component
public class DeleteSingleDocumentTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// creating web client object
		WebClient client = WebClient.create("http://localhost:4041");
		
		Mono<Void> mono = client	
													.delete()
													.uri("/employee/remove/101")
													.retrieve()
													.bodyToMono(Void.class);
													
			mono.subscribe(System.out::println);
			System.out.println("deleted");

	}//method

}//class
