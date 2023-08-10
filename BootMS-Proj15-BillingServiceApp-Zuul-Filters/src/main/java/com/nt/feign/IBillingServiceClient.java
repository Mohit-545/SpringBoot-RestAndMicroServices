//IBillingServiceClient.java
package com.nt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Payment-Gateway")
public interface IBillingServiceClient {
	
	@GetMapping("/payment/options")
	public ResponseEntity<String> getPaymentOptions();

}//interface
