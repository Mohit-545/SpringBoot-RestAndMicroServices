//ActorConsumerRunner2.java
package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorConsumerRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class Object
		RestTemplate template = new RestTemplate();
		//add/define the base URL
		String baseUrl = "http://localhost:4040/RestProj11-ProducerApp-WebApplication/actorapi/register";
	 
		//prepare JSON data
		String json_body = "{\"id\": 1500, \"name\": \"Akash \",\"age\": 26,\"city\": \"Chennai\"}";
	
		//prepare Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//prepare Http request as HttpEntity obj having head and body
		HttpEntity<String> request = new HttpEntity<String>(json_body,headers);
		
		//make Http request call in POST Mode
		ResponseEntity<String> response = template.postForEntity(baseUrl, request, String.class);
		
		//display the recieved details from the response
		System.out.println("Response Body(Output) :: "+response.getBody());
		System.out.println("Response Status Code Value :: "+response.getStatusCode().value());
		System.out.println("Response Status Code :: "+response.getStatusCode());
		System.out.println("Response Headers :: "+response.getHeaders().toString());
		
		System.exit(0);

	}//method

}//class
