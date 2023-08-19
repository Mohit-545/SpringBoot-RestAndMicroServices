//IPLPlayer.java
package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MSMP_IPL_PLAYER_INFO")
@Setter
@Getter
@RequiredArgsConstructor
public class IPLPlayer implements Serializable {
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "PID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@NonNull
	@Column(length = 20)
	private String pname;
	
	@NonNull
	@Column(length = 10)
	private Integer age;

	@NonNull
	@Column(length = 20)
	private String role;
	
	@NonNull
	@ManyToOne(targetEntity = IPLTeam.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "t_id",referencedColumnName = "teamId")  // for FK column
	private IPLTeam team;
	
	
	public IPLPlayer() {
		System.out.println("IPLPlayer :: 0-param constructor");
	}//constructor


	@Override
	public String toString() {
		return "IPLPlayer [pid=" + pid + ", pname=" + pname + ", age=" + age + ", role=" + role + ", team=" + team
				+ "]";
	}//toString()
	
	
}//class
