package com.fashionstore.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
//8 fields including employeeId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private long employeeId;
	
	@Column(name="employee_email")
	private String employeeEmail;
	
	@Column(name="employee_password")
	private String employeePassword;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="employee_mobileNo")
	private long employeeMobileNo;
		
	@Column(name="employee_address")
	private String employeeAddress;

	@ManyToOne(targetEntity = Employee.class)
	private Manager manager;



	
	

	
}
