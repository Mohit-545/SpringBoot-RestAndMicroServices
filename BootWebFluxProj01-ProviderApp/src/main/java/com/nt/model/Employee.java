//Employee.java
package com.nt.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "REACTIVE_EMPLOYEE")
public class Employee {
	@Id
	private Integer id;
	private String empName;
	private String empDept;
	private Double empSal;

}//class
