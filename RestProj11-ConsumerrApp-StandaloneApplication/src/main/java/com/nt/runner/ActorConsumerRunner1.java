//ActorConsumerRunner1.java
package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorConsumerRunner1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class Object
		RestTemplate template = new RestTemplate();
		//add/define the base URL
		String baseUrl = "http://localhost:4040/RestProj11-ProducerApp-WebApplication/actorapi/actor/{id}/{name}";
		//Generate Http request with GET Mode to consume the WebServices(API)
		//ResponseEntity<String> response = template.getForEntity(baseUrl, String.class, 1001,"Mohit Chotalia");
		ResponseEntity<String> response = template.getForEntity(baseUrl, String.class, Map.of("name","Ramesh", "id", 2001));
		//display the recieved details from the response
		System.out.println("Response Body(Output) :: "+response.getBody());
		System.out.println("Response Status Code Value :: "+response.getStatusCode().value());
		System.out.println("Response Status Code :: "+response.getStatusCode());
		System.out.println("Response Headers :: "+response.getHeaders().toString());
		
		//System.exit(0);

	}//method

}//class
