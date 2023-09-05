//UserDetails.java
package com.nt.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Table(name="SECURITY_USERS")
@Data
@Entity
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer unid;
	
	@Column(length = 20)
	private String uname;
	
	@Column(length = 200)
	private String pwd;
	
	@Column(length = 30)
	private String email;
	
	@Column(length = 2)
	private boolean status=true;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "SECURITY_ROLES",
										joinColumns = @JoinColumn(name="USER_ID", referencedColumnName = "unid"))
	@Column(name = "role")
	private Set<String> roles;

}//class
