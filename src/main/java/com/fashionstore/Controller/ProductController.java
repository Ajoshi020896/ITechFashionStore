package com.fashionstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.Entities.Product;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// adding product
	@PostMapping("/addproduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {

		try {

			Product productResponse = productService.addProduct(product);
			return new ResponseEntity<Product>(productResponse, HttpStatus.CREATED);
		} catch (Exception e) {

			ControllerException ce = new ControllerException("601", "Something wrong with the Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	// get all products
	@GetMapping("/getallproducts")
	public ResponseEntity<?> getAllProducts() {

		try {

			List<Product> productResponse = productService.getAllProducts();
			return new ResponseEntity<List<Product>>(productResponse, HttpStatus.OK);
		} catch (EntityNotFoundException e) {

			return new ResponseEntity<String>("Products list is empty", HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "Something wrong with the Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

	// get product by id
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long productId) {

		try {

			Product productResponse = productService.getProductById(productId);
			return new ResponseEntity<Product>(productResponse, HttpStatus.OK);

		} catch (EntityNotFoundException e) {

			return new ResponseEntity<String>("No Product found with Id "+productId, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "Something wrong with the Controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}

}
