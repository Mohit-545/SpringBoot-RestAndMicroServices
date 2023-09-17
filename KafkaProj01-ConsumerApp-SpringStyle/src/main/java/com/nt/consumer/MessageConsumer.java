//MessageConsumer.java
package com.nt.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class MessageConsumer {

	public static void main(String[] args) {
		// Creating ConnectionProperties as key=value pair in java.util.properties class object
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "grp1_consumers");
		
		//creating kafka Consumer object
		KafkaConsumer<String , String> consumer = new KafkaConsumer<String , String>(props);
		
		//Subscribing to Topic destination through MessageBroker
		consumer.subscribe(Arrays.asList("nit-tpc-spring"));
		
		//Performing Polling to check and read the message 
		while(true) {
			//poll and get the consumer records
			ConsumerRecords<String , String> records = consumer.poll(Duration.ofMillis(2000));
			//reading and displaying the message
			for(ConsumerRecord<String, String> record : records) {
				System.out.println("Message :: "+record.value());
			}//for
		}//while
		
	}//main

}//class
