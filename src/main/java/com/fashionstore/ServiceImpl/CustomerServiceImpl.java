package com.fashionstore.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashionstore.DTO.AddingAdminDTO;
import com.fashionstore.DTO.AddingCustomerDTO;
import com.fashionstore.DTO.CustomerResponseDTO;
import com.fashionstore.DTO.ManagerResponseDTO;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Manager;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.FeignClient.FeignServiceSprinterUtil;
import com.fashionstore.Repository.CustomerRepository;
import com.fashionstore.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private FeignServiceSprinterUtil feignServiceSprinterUtil;

	@Override
	public CustomerResponseDTO addCustomer(AddingCustomerDTO addingCustomerDTO) {

		Customer customer = new Customer();

		customer.setCustomerName(addingCustomerDTO.getCustomerName());
		customer.setCustomerAddress(addingCustomerDTO.getCustomerAddress());
		customer.setCustomerMobileNo(addingCustomerDTO.getCustomerMobileNo());
		customer.setCreatedDate(new Date());

		Customer customerdb = customerRepository.save(customer);

		CustomerResponseDTO responseDto = new CustomerResponseDTO();

		responseDto.setCustomerName(customerdb.getCustomerName());
		responseDto.setCustomerAddress(customerdb.getCustomerAddress());
		responseDto.setCustomerMobileNo(customerdb.getCustomerMobileNo());

		return responseDto;

	}

	@Override
	public Customer getCustomerById(Long customerId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer.isEmpty()) {

			throw new EntityNotFoundException("601", "Customer With " + customerId + " not found");
		}

		else {

			Customer customerDb = optionalCustomer.get();

			return customerDb;
		}
	}

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> customers = customerRepository.findAll();

		if (customers.isEmpty()) {

			throw new EntityNotFoundException("601", "Customers List is empty");

		} else {

			return customers;
		}

	}

	@Override
	public String deleteCustomerById(Long customerId) {

		customerRepository.deleteById(customerId);

		return "Customert with " + customerId + " deleted";
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = customerRepository.save(customer);
		
		return updatedCustomer;
	}

	@Override
	public ResponseEntity<?> getAllProductsFromSprinter() {
		
		return feignServiceSprinterUtil.getallproductsbysprinter();
	}

}
