package com.fashionstore.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Sprinter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sprinter_id")
	private Long sprinterId;
	
	@Column(name="sprinter_name")
	private String sprinterName;
	
	@Column(name="sprinter_mobile_no")
	private Long sprinterMobileNo;
	
	@Column(name="sprinter_address")
	private String sprinterAddress;
	
	@Column(name="sprinter_convence_type")
	private String sprinterConvenceType;
	
	@OneToOne
	private Manager manager;
}
