package com.fashionstore.DTO;

import java.util.Date;
import java.util.List;

import com.fashionstore.Entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrderResponseDTO {
	
	private Long orderId;
	private String orderType;
	private Date orderDate;
	private Date delieveryDate;
	private CustomerOrderResponseDTO customerOrderResponseDto;
	private SprinterOrderResponseDTO sprinterOrderResponseDTO;
	private List<Product> productResponse;
	private ManagerResponseForAdminDTO managerResponseForAdminDTO;


}
