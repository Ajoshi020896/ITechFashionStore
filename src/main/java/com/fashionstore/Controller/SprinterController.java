package com.fashionstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;
import com.fashionstore.Entities.Sprinter;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Service.SprinterService;

@RestController
@RequestMapping("/sprinter")
public class SprinterController {

	@Autowired
	private SprinterService sprinterService;

// get product by id
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long productId) {

		try {

			Product productResponse = sprinterService.getProductById(productId);
			return new ResponseEntity<Product>(productResponse, HttpStatus.OK);

		} catch (EntityNotFoundException e) {

			return new ResponseEntity<String>("No Product found with Id " + productId, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "Something wrong with the Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}
	
	
	// getting customer by id
		@GetMapping("/customer/{id}")
		public ResponseEntity<?> getCustomerById(@PathVariable("id") Long customerId) {
			try {
				Customer responseCustomer = sprinterService.getCustomerById(customerId);
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
		

}
