package com.fashionstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddingManagerDTO {
	
	private String managerName;
	private String managerEmail;
	private String managerPassword;
	private String managerAddress;
	private long managerMobileNo;
	


}
