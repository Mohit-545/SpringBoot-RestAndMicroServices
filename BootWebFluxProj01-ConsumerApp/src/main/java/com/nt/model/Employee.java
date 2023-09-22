//Employee.java
package com.nt.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private Integer id;
	private String empName;
	private String empDept;
	private Double empSal;

}//class
