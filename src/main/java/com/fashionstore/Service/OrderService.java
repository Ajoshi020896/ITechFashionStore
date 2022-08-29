package com.fashionstore.Service;



import com.fashionstore.DTO.AddingOrdersDTO;
import com.fashionstore.DTO.FinalOrderResponseDTO;
import com.fashionstore.Entities.Order;

public interface OrderService {

	FinalOrderResponseDTO addOrder(AddingOrdersDTO addAddingOrdersDTO);

}
