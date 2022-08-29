package com.fashionstore.DTO;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderResponseDTO {
	
	private long customerId;
	
	private String customerName;
	
	private long customerMobileNo;
	
	private String customerAddress;

}
