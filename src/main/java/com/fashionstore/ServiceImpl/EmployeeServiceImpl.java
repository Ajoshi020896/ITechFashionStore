package com.fashionstore.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fashionstore.DTO.AddingEmployeeRequestDto;
import com.fashionstore.DTO.AddingEmployeeResponseDto;
import com.fashionstore.DTO.EmployeeLoginDTO;
import com.fashionstore.DTO.EmployeeResponseDTO;
import com.fashionstore.DTO.UpdatedEmployeeResponseDTO;
import com.fashionstore.DTO.UpdatedManagerResponseDTO;
import com.fashionstore.Entities.Employee;
import com.fashionstore.Entities.Manager;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.FeignClient.FeignServiceSprinterUtil;
import com.fashionstore.Repository.EmployeeRepository;
import com.fashionstore.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FeignServiceSprinterUtil feignServiceSprinterUtil;

	@Override
	public String employeeLogin(EmployeeLoginDTO employeeLoginDto) {

		String employeeEmail = employeeLoginDto.getEmployeeEmail();
		String employeePassword = employeeLoginDto.getEmployeePassword();

		Employee employeeDb = employeeRepository.findByEmployeeEmailAndEmployeePassword(employeeEmail,
				employeePassword);

		if (employeeDb == null) {

			throw new EntityNotFoundException("601", "No managers found");
		} else {

			return "Welcome to the Login Page " + employeeDb.getEmployeeName();
		}
	}

	@Override
	public ResponseEntity<?> getAllProductsFromSprinter() {
		return feignServiceSprinterUtil.getallproductsbysprinter();
	}
}

	
