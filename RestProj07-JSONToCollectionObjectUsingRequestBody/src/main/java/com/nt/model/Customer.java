//Customer.java
package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private Integer cno;
	private String cname;
	private List<Company> companiesList;
	private LocalDate dob;
	private LocalDateTime loginTime;
	private List<Map<String,Long>> familyIds;

}//class
