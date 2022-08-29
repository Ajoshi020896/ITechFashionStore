package com.fashionstore.Controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.DTO.AddingAdminDTO;
import com.fashionstore.DTO.AddingCustomerDTO;
import com.fashionstore.DTO.CustomerResponseDTO;
import com.fashionstore.DTO.ManagerResponseDTO;
import com.fashionstore.Entities.Admin;
import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Manager;
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Service.CustomerService;

import lombok.Getter;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// adding customer in the database
	@PostMapping("/addcustomer")
	public ResponseEntity<?> addingCustomer(@RequestBody AddingCustomerDTO addingCustomerDTO) {

		try {
			CustomerResponseDTO responseDto = customerService.addCustomer(addingCustomerDTO);
			return new ResponseEntity<CustomerResponseDTO>(responseDto, HttpStatus.CREATED);
		} catch (BusinessException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// getting customer by id
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long customerId) {
		try {
			Customer responseCustomer = customerService.getCustomerById(customerId);
			return new ResponseEntity<Customer>(responseCustomer, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException("601", e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}
	}
	
	
	//customer login
	//@GetMapping
//	public ResponseEntity<?> loginCustomer()

	// get all customers
	@GetMapping("/getallcustomers")
	public ResponseEntity<?> getAllCustomers() {
		try {
			List<Customer> responseCustomers = customerService.getAllCustomers();
			return new ResponseEntity<List<Customer>>(responseCustomers, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException("601", e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}

	}

	// delete customer by id
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("id") Long customerId) {
		try {
			String response = customerService.deleteCustomerById(customerId);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}
	}

	// update customer details
	@PutMapping("/updatecustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		try {
			Customer response = customerService.updateCustomer(customer);
			return new ResponseEntity<Customer>(response, HttpStatus.OK);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}
	}
}
