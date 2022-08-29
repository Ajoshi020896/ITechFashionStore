package com.fashionstore.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fashionstore.DTO.AddingEmployeeRequestDto;
import com.fashionstore.DTO.AddingEmployeeResponseDto;
import com.fashionstore.DTO.AddingManagerDTO;
import com.fashionstore.DTO.EmployeeResponseDTO;
import com.fashionstore.DTO.ManagerLoginRequestDTO;
import com.fashionstore.DTO.ManagerResponseDTO;
import com.fashionstore.DTO.UpdatedEmployeeResponseDTO;
import com.fashionstore.DTO.UpdatedManagerResponseDTO;
import com.fashionstore.Entities.Employee;
import com.fashionstore.Entities.Manager;

public interface ManagerService {

	String managerLogin(ManagerLoginRequestDTO managerLoginRequestDTO);
	
	AddingEmployeeResponseDto addEmployee(AddingEmployeeRequestDto employee);
	
	List<AddingEmployeeResponseDto> addEmployees(List<AddingEmployeeRequestDto> employeesList);
	
	EmployeeResponseDTO getEmployeeById(Long employeeId);

	String deleteEmployeeById(Long employeeId);

	UpdatedEmployeeResponseDTO updateEmployee(Employee employee);

	List<AddingEmployeeResponseDto> getAllemployees();

	

	

	

}
