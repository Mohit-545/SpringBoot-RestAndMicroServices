//Customer.java
package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private Integer cno;
	private String cname;
	private double billAmt;
	private String[] favcolors;
	private List<String> courses;
	private Set<Long> phoneNumbers;
	private Map<String, Long> idDetails;
	//HAS-A property
	private Company company;

}//class
