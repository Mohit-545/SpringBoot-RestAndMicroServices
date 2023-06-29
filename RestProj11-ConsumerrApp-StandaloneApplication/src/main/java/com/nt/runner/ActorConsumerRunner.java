//ActorConsumerRunner.java
package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorConsumerRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class Object
		RestTemplate template = new RestTemplate();
		//add/define the base URL
		String url = "http://localhost:4040/RestProj11-ProducerApp-WebApplication/actorapi/actor/Mohit Chotalia";
		//Generate Http request with GET Mode to consume the WebServices(API)
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		//display the recieved details from the response
		System.out.println("Response Body(Output) :: "+response.getBody());
		System.out.println("Response Status Code Value :: "+response.getStatusCode().value());
		System.out.println("Response Status Code :: "+response.getStatusCode());
		
		System.exit(0);

	}//method

}//class
