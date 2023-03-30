package com.fashionstore.Controller;

import java.util.List;

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

import com.fashionstore.DTO.AddingEmployeeRequestDto;
import com.fashionstore.DTO.AddingEmployeeResponseDto;
import com.fashionstore.DTO.EmployeeLoginDTO;
import com.fashionstore.DTO.EmployeeResponseDTO;
import com.fashionstore.DTO.UpdatedEmployeeResponseDTO;
import com.fashionstore.Entities.Employee;
import com.fashionstore.Entities.Manager;
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Service.EmployeeService;

@RestController
@RequestMapping("itechfashionstore/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	

	// employee login
	@GetMapping("/employeelogin")
	public ResponseEntity<?> employeeLogin(@RequestBody EmployeeLoginDTO employeeLoginDto) {
		try {
			String loginResponse = employeeService.employeeLogin(employeeLoginDto);
			return new ResponseEntity<String>(loginResponse, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}

	}
	
	@GetMapping("/getallproductsfromsprinter")
	public ResponseEntity<?> getAllProductsFromSprinter() {
		try {
			ResponseEntity<?> responseDto = employeeService.getAllProductsFromSprinter();
			return new ResponseEntity<>(responseDto.getBody(), HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException("601", e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("404", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorCode(), HttpStatus.BAD_REQUEST);

		}
	}
}

	