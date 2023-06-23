//Tourist.java
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "REST_TOURIST_TABLE")
@NoArgsConstructor
@AllArgsConstructor
public class Tourist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tId;
	@Column(length = 30)
	private String name;
	@Column(length = 20)
	private String city;
	@Column(length = 20)
	private String packageType;
	@Column
	private Double budget;

}//class
