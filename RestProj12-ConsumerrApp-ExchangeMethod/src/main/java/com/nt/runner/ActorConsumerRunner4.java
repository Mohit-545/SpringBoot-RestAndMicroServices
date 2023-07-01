//ActorConsumerRunner4.java
package com.nt.runner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.entity.Actor;

@Component
public class ActorConsumerRunner4 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class Object
		RestTemplate template = new RestTemplate();
		//add/define the base URL
		String baseUrl = "http://localhost:4040/RestProj11-ProducerApp-WebApplication/actorapi/allReport";
		
		//invoke the provider app's REST operation method
		ResponseEntity<String> response = template.exchange(baseUrl, HttpMethod.GET, null, String.class);
		
		//display the received details from the response
		System.out.println("Response Body(Final Output As JSON Content) :: "+response.getBody());
		System.out.println("Response Status Code Value :: "+response.getStatusCode().value());
		System.out.println("Response Status Code :: "+response.getStatusCode());
		System.out.println("=========================================================================================");
		
		//converting array/list of Json docs to List<Model> class object using Jackson api
		String json_body = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> list = mapper.readValue(json_body, new TypeReference<List<Actor>>() {});
		list.forEach(System.out::println);
		
		System.exit(0);

	}//method

}//class
