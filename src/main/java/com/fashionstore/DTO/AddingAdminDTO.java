package com.fashionstore.DTO;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddingAdminDTO {
	
	private long adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	private String adminAddress;
	private long adminMobileNo;	

}
