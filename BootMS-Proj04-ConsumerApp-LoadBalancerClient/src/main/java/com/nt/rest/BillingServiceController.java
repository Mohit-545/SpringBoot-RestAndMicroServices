//BillingServiceController.java
package com.nt.rest;

import java.net.URI;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/billing")
public class BillingServiceController {
	@Autowired
	private LoadBalancerClient clientComp;
	
	@GetMapping("/info")
	public ResponseEntity<String> getFinalGeneratedBillAmount(){
		double billAmt = new Random().nextDouble(10000.0);
		//use client comp to get the producer MS service instance from the Eureka server
		ServiceInstance instance = clientComp.choose("Payment-Gateway");
		//get details from the Service instance
		URI uri = instance.getUri();
		//use the first service instance from the List of Instances and get Producer service URI to make it as URL
		String url = uri.toString()+"/payment/options";
		//create the RestTemplate object
		RestTemplate template = new RestTemplate();
		//invoke the Producer MS service method or operation by generating Http call
		ResponseEntity<String> response = template.exchange(url,HttpMethod.GET, null, String.class);
		//generate the final result 
		String finalResult = "Final Bill Amount :: "+billAmt+" and the Payment Options are :: "+response.getBody();
		
		return new ResponseEntity<String>(finalResult, HttpStatus.OK);
		
	}//method

}//class
