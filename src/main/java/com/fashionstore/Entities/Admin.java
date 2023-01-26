package com.fashionstore.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="admin_id")
	private long adminId;
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="admin_Email",unique = true)
	private String adminEmail;
	
	@Column(name="admin_password")
	private String adminPassword;
	
	@Column(name="admin_address")
	private String adminAddress;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="admin_mobileNo")
	private long adminMobileNo;

	
}
