//MessageProducer.java
package com.nt.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class MessageProducer {

	public static void main(String[] args) {
		// Creating ConnectionProperties as key=value pair in java.util.properties class object
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		//creating kafka producer object
		KafkaProducer<String , String> producer = new KafkaProducer<String , String>(props);
		
		//creating producer record object representating the message
		String msg = "Welcome to Apache Kafka Messaging";
		String topicName = "nit-tpc-spring";
		ProducerRecord<String , String> record = new ProducerRecord<String, String>(topicName, msg);
		
		//sending the message i.e. record
		producer.send(record);
		
		//flush the message 
		producer.flush();
		
		//close the connection with the bootstrap server
		producer.close();
		System.out.println("Message Sent");
		
	}//main

}//class
