package com.fashionstore.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
	
	private Long orderId;
	private Date orderDate;
	private String orderType;
	private Date deliveryDate;
	private CustomerOrderResponseDTO customerOrderResponseDTO;
	
	
	
	

}
