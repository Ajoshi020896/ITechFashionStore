package com.fashionstore.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="manager_id")
	private long managerId;
	
	@Column(name = "manager_email")
	private String managerEmail;
	
	@Column(name="manager_password")
	private String managerPassword;
	
	@Column(name="manager_name")
	private String managerName;
	
	@Column(name="manager_address")
	private String managerAddress;
	
	@Column(name = "manager_mobileNo")
	private long managerMobileNo;
	
	@JsonIgnore
	@Column(name="update_date")
	private Date updateDate;
	
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="manager")
	private List<Employee> employees;
	
   




    

}
