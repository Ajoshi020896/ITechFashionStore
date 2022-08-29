package com.fashionstore.Service;

import java.util.List;

import com.fashionstore.DTO.AddingAdminDTO;
import com.fashionstore.DTO.AddingCustomerDTO;
import com.fashionstore.DTO.CustomerResponseDTO;
import com.fashionstore.Entities.Customer;

public interface CustomerService {

	CustomerResponseDTO addCustomer(AddingCustomerDTO addingCustomerDTO);

	Customer getCustomerById(Long customerId);

	List<Customer> getAllCustomers();

	String deleteCustomerById(Long customerId);

	Customer updateCustomer(Customer customer);

}
