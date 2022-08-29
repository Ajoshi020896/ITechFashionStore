package com.fashionstore.DTO;

import java.util.List;

import com.fashionstore.Entities.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinalOrderResponseDTO {
	
	private Long orderId;
	private OrderStatus orderStatus;
	private Long productCount;
	private Double TotalOrderPrice;
	private CustomerOrderResponseDTO customerResponse;
	private List<ProductOrderResponseDTO> productResponse;
	private SprinterOrderResponseDTO sprinterResponse;

}
