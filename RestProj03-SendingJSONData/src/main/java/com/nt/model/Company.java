//Company.java
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	
	private String cname;
	private String addrs;
	private String type;
	private Integer size;

}//class
