//TouristNotFoundException.java
package com.nt.error;

public class TouristNotFoundException extends RuntimeException {
	
	public TouristNotFoundException() {
		super();
	}//constructor
	
	public TouristNotFoundException(String msg) {
		super(msg);
	}//paramConstructor

}//class
