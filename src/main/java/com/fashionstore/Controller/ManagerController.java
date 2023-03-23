package com.fashionstore.Controller;

import java.util.List;
import com.fashionstore.Exception.EntityNotFoundException;
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
import com.fashionstore.DTO.AddingManagerDTO;
import com.fashionstore.DTO.EmployeeResponseDTO;
import com.fashionstore.DTO.ManagerLoginRequestDTO;
import com.fashionstore.DTO.ManagerResponseDTO;
import com.fashionstore.DTO.OrderResponseDTO;
import com.fashionstore.DTO.OrderResponseWithSprinterDTO;
import com.fashionstore.DTO.UpdatedEmployeeResponseDTO;
import com.fashionstore.DTO.UpdatedManagerResponseDTO;
import com.fashionstore.Entities.Employee;
import com.fashionstore.Entities.Manager;
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	// manager login
	@GetMapping("/managerlogin")
	public ResponseEntity<?> managerLogin(ManagerLoginRequestDTO managerLoginRequestDTO) {

		try {
			String response = managerService.managerLogin(managerLoginRequestDTO);
			return new ResponseEntity<String>(response, HttpStatus.FOUND);

		} catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getMessage());
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);
		}
	}

	// adding employees
	@PostMapping("/addemployee")
	public ResponseEntity<?> addingemployee(@RequestBody AddingEmployeeRequestDto employee) {

		try {
			AddingEmployeeResponseDto response = managerService.addEmployee(employee);
			return new ResponseEntity<AddingEmployeeResponseDto>(response, HttpStatus.OK);
		} 
		catch (Exception e) {
			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}

	}

	// adding multiple employees at a time
	@PostMapping("/addemployees")
	public ResponseEntity<?> addingEmployees(@RequestBody List<AddingEmployeeRequestDto> employeesList) {
		try {
			List<AddingEmployeeResponseDto> responseList = managerService.addEmployees(employeesList);
			return new ResponseEntity<List<AddingEmployeeResponseDto>>(responseList, HttpStatus.OK);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		}
	}

	// get employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long employeeId) {
		try {
			EmployeeResponseDTO responseDto = managerService.getEmployeeById(employeeId);
			return new ResponseEntity<EmployeeResponseDTO>(responseDto, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		}

	}

	// delete employee by id
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long employeeId) {
		try {
			String response = managerService.deleteEmployeeById(employeeId);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}
	}

	// update employee details
	@PutMapping("/updateemployee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			UpdatedEmployeeResponseDTO response = managerService.updateEmployee(employee);
			return new ResponseEntity<UpdatedEmployeeResponseDTO>(response, HttpStatus.OK);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		}
	}

	// get all employees
	@GetMapping("/getallemployees")
	public ResponseEntity<?> getAllemployees() {
		try {
			List<AddingEmployeeResponseDto> response = managerService.getAllemployees();
			return new ResponseEntity<List<AddingEmployeeResponseDto>>(response, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(),"Employees Not found" );
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		}
	}
	
	
	@GetMapping("/getOrderDetailsWithSprinter/{id}")
	public ResponseEntity<?> getOrderDetailsWithSprinter(@PathVariable("id") Long orderId) {
		try {
			OrderResponseWithSprinterDTO response = managerService.getOrderDetailsWithSprinter(orderId);
			return new ResponseEntity<OrderResponseWithSprinterDTO>(response, HttpStatus.FOUND);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorDescription() );
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		}

		catch (Exception e) {
			e.printStackTrace();

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/getallproductsfromsprinter")
	public ResponseEntity<?> getAllProductsFromSprinter() {
		try {
			ResponseEntity<?> responseDto = managerService.getAllProductsFromSprinter();
			return new ResponseEntity<>(responseDto.getBody(), HttpStatus.OK);
		}

		catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException("400", e.getMessage());
			return new ResponseEntity<String>(ce.getErrorCode(), HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("404", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorCode(), HttpStatus.BAD_REQUEST);

		}
	}
}
