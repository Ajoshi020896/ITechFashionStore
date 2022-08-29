package com.fashionstore.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;
import com.fashionstore.Entities.Sprinter;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Repository.CustomerRepository;
import com.fashionstore.Repository.ProductRepository;
import com.fashionstore.Repository.SprinterRepository;
import com.fashionstore.Service.SprinterService;

@Service
public class SprinterServiceImpl implements SprinterService {
	@Autowired
	private SprinterRepository sprinterRepository;

	@Autowired
	private ProductRepository productRepository;

	private CustomerRepository customerRepository;

	@Override
	public Product getProductById(Long productId) {

		Optional<Product> optionalProduct = productRepository.findById(productId);

		if (optionalProduct.isEmpty()) {

			throw new EntityNotFoundException("601", "No Product found with " + productId + " Id");
		}

		else {

			Product product = optionalProduct.get();

			return product;
		}
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
	
	
}
