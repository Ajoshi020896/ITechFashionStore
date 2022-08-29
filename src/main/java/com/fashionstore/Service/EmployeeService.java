package com.fashionstore.Service;

import java.util.List;

import com.fashionstore.DTO.AddingEmployeeRequestDto;
import com.fashionstore.DTO.AddingEmployeeResponseDto;
import com.fashionstore.DTO.EmployeeLoginDTO;
import com.fashionstore.DTO.EmployeeResponseDTO;
import com.fashionstore.DTO.UpdatedEmployeeResponseDTO;
import com.fashionstore.Entities.Employee;
import com.fashionstore.Entities.Manager;

public interface EmployeeService {
	
	
	

	

	String employeeLogin(EmployeeLoginDTO employeeLoginDto);

	

}
