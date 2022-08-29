package com.fashionstore.DTO;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddingAdminResponseDTO {
	
private long adminId;
	
	
	private String adminName;
	private String adminEmail;
	private String adminAddress;
	private Date createdDate;	
	private long adminMobileNo;

	

}
