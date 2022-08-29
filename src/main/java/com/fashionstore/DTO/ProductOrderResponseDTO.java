package com.fashionstore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderResponseDTO {

	private Long productId;
	private String productName;
	private int productSize;
	private Long productPrice;
}
