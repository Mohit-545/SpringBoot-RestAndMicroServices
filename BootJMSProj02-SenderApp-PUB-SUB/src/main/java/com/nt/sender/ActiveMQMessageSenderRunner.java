//ActiveMQMessageSenderRunner.java
package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageSenderRunner implements CommandLineRunner {

	@Autowired
	private JmsTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		// using LAMDA Style anonymous inner class
		template.send("testmq2", ses->ses.createTextMessage("From Sender at :: Hi, new message sent from mohit on "+new Date()));
		System.out.println("Message Sent");

	}//method

}//class
