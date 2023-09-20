//MessageStore.java
package com.nt.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {
	
	private List<String> list = new ArrayList<String>();
	
	public void addMessage(String msg) {
		list.add(msg);
	}//method
	
	public List<String> getAllMessages() {
		return list;
	}//method

}//class
