//JMSMessageConsumer.java
package com.nt.reciever;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSMessageConsumer  {

	@Autowired
	private JmsTemplate template;
	
	@JmsListener(destination = "testmq1")
	public void readMessage(String text) {
		System.out.println("Recieved Message :: "+text);

	}//method

}//class
