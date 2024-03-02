package com.fashionstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashionstore.DTO.AddingAdminDTO;
import com.fashionstore.DTO.AddingAdminResponseDTO;
import com.fashionstore.DTO.AddingManagerDTO;
import com.fashionstore.DTO.AdminLoginDTO;
import com.fashionstore.DTO.AdminOrderResponseDTO;
import com.fashionstore.DTO.ManagerResponseDTO;
import com.fashionstore.DTO.UpdatedManagerResponseDTO;
import com.fashionstore.Entities.Manager;
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Exception.ControllerException;
import com.fashionstore.Service.AdminService;
import com.fashionstore.Exception.EntityNotFoundException;

@Controller
@RequestMapping("itechfashionstore/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// adding admin in the database
	@PostMapping("/addadmin")
	public ResponseEntity<?> addingAdmin(@RequestBody AddingAdminDTO addingAdminDTO) {

		try {

			AddingAdminResponseDTO response = adminService.addAdmin(addingAdminDTO);
			return new ResponseEntity<AddingAdminResponseDTO>(response, HttpStatus.CREATED);
		} catch (BusinessException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// admin login
	@GetMapping("/adminlogin")
	public ResponseEntity<?> adminLogin(@RequestBody AdminLoginDTO adminLogindto) {
		try {

			String string = adminService.adminLogin(adminLogindto);
			return new ResponseEntity<String>(string, HttpStatus.ACCEPTED);
		}

		catch (BusinessException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// adding managers in the database
	@PostMapping("/addmanager")
	public ResponseEntity<?> addingmanagers(@RequestBody AddingManagerDTO addingManagerDTO) {

		try {

			Manager managers = adminService.addManager(addingManagerDTO);
			return new ResponseEntity<Manager>(managers, HttpStatus.CREATED);
		} catch (BusinessException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

		catch (Exception e) {

			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	// get all managers
	@GetMapping("/getallmanagers")
	public ResponseEntity<?> getmanagers() {

		try {
			List<ManagerResponseDTO> response = adminService.getAllManagers();
			return new ResponseEntity<List<ManagerResponseDTO>>(response, HttpStatus.FOUND);

		} catch (EntityNotFoundException e) {

			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorDescription());
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<String>(ce.getErrorDescription(), HttpStatus.BAD_REQUEST);
		}
	}

	// get manager By id
	@GetMapping("/manager/{id}")
	public ResponseEntity<?> getManagerById(@PathVariable("id") Long managerId) {
		try {
			ManagerResponseDTO responseDto = adminService.getManagerById(managerId);
			return new ResponseEntity<ManagerResponseDTO>(responseDto, HttpStatus.FOUND);
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

	// delete manager by id
	@DeleteMapping("/manager/{id}")
	public ResponseEntity<?> deleteManagerById(@PathVariable("id") Long managerId) {
		try {
			String response = adminService.deleteManagerById(managerId);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		}
	}

	// update manager details
	@PutMapping("/updatemanager")
	public ResponseEntity<?> updateManager(@RequestBody Manager manager) {
		try {
			UpdatedManagerResponseDTO response = adminService.updateManager(manager);
			return new ResponseEntity<UpdatedManagerResponseDTO>(response, HttpStatus.OK);
		}
		catch (Exception e) {
			ControllerException ce = new ControllerException("601", "something wrong with Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getallproductsfromsprinter")
	public ResponseEntity<?> getAllProductsFromSprinter() {
		try {
			ResponseEntity<?> responseDto = adminService.getAllProductsFromSprinter();
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
