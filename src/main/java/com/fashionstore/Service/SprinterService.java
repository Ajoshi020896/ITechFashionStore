package com.fashionstore.Service;

import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;
import com.fashionstore.Entities.Sprinter;

public interface SprinterService {

	Product getProductById(Long productId);

	Customer getCustomerById(Long customerId);

}
