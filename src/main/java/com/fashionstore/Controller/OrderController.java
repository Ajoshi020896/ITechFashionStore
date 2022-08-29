package com.fashionstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.DTO.AddingOrdersDTO;
import com.fashionstore.DTO.FinalOrderResponseDTO;
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Repository.OrderRepository;
import com.fashionstore.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	// adding Orders
	@PostMapping("/addorder")
	public ResponseEntity<?> addOrders(@RequestBody AddingOrdersDTO addingOrdersDTO) {

		try {

			FinalOrderResponseDTO finalResponse=orderService.addOrder(addingOrdersDTO);
			return new ResponseEntity<FinalOrderResponseDTO>(finalResponse, HttpStatus.OK);
		} catch (BusinessException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorDescription());
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			e.printStackTrace();
			ControllerException ce = new ControllerException("601","Something bad with the controller");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);
		}
		

	}
	
	
}
