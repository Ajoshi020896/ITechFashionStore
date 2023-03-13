package com.fashionstore.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Repository.EmployeeRepository;
import com.fashionstore.Repository.ManagerRepository;
import com.fashionstore.Service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String managerLogin(ManagerLoginRequestDTO managerLoginRequestDTO) {

		String emailId = managerLoginRequestDTO.getManagerEmail();
		String password = managerLoginRequestDTO.getManagerPassword();

		Manager managerDb = managerRepository.findByManagerEmailAndManagerPassword(emailId, password);

		if (managerDb == null) {

			throw new EntityNotFoundException("601", "manager with particular emailId and password bot found");

		}

		else {

			return "Welcome to login page " + managerDb.getManagerName();
		}

	}

	@Override
	public AddingEmployeeResponseDto addEmployee(AddingEmployeeRequestDto employee) {

		Employee employee1 = new Employee();
		employee1.setEmployeeName(employee.getEmployeeName());
		employee1.setCreatedDate(new Date());
		employee1.setEmployeeAddress(employee.getEmployeeAddress());
		employee1.setEmployeeEmail(employee.getEmployeeEmail());
		employee1.setEmployeeMobileNo(employee.getEmployeeMobileNo());
		employee1.setUpdatedDate(new Date());
		employee1.setEmployeePassword(employee.getEmployeePassword());

		Employee employee2 = employeeRepository.save(employee1);

		AddingEmployeeResponseDto response = new AddingEmployeeResponseDto();
		response.setEmployeeName(employee2.getEmployeeName());
		response.setEmployeeEmail(employee2.getEmployeeEmail());
		response.setEmployeeMobileNo(employee2.getEmployeeMobileNo());
		response.setEmployeeAddress(employee2.getEmployeeAddress());
		
		return response;

	}

	@Override
	public List<AddingEmployeeResponseDto> addEmployees(List<AddingEmployeeRequestDto> employeesList) {

		List<AddingEmployeeRequestDto> list = employeesList;

		List<Employee> allEmployees = list.stream().map(response -> modelMapper.map(response, Employee.class))
				.collect(Collectors.toList());

		List<Employee> employees = employeeRepository.saveAll(allEmployees);

		List<AddingEmployeeResponseDto> allResponseEmployees = employees.stream()
				.map(response -> modelMapper.map(response, AddingEmployeeResponseDto.class))
				.collect(Collectors.toList());

		return allResponseEmployees;

	}

	@Override
	public EmployeeResponseDTO getEmployeeById(Long employeeId) {

		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

		if (optionalEmployee.isEmpty()) {

			throw new EntityNotFoundException("601", "Employee With " + employeeId + " not found");
		}

		else {

			Employee employeeDb = optionalEmployee.get();

			EmployeeResponseDTO responseDto = new EmployeeResponseDTO();

			responseDto.setEmployeeName(employeeDb.getEmployeeName());
			responseDto.setEmployeeEmail(employeeDb.getEmployeeEmail());
			responseDto.setEmployeeId(employeeId);
			responseDto.setEmployeeMobileNo(employeeDb.getEmployeeMobileNo());
			responseDto.setEmployeeAddress(employeeDb.getEmployeeAddress());

			return responseDto;
		}

	}

	@Override
	public String deleteEmployeeById(Long employeeId) {
		
		Optional<Employee> optionalEmployee=employeeRepository.findById(employeeId);
		
		if(optionalEmployee.isEmpty()) {
			
			throw new EntityNotFoundException("601","employee not Found");
		}

		employeeRepository.deleteById(employeeId);

		return "Employee deleted";
	}

	@Override
	public UpdatedEmployeeResponseDTO updateEmployee(Employee employee) {

		Employee updatedEmployee = employeeRepository.save(employee);

		UpdatedEmployeeResponseDTO updatedResponse = new UpdatedEmployeeResponseDTO();

		updatedResponse.setEmployeeName(updatedEmployee.getEmployeeName());
		updatedResponse.setUpdatedDate(new Date());
		updatedResponse.setEmployeeAddress(updatedEmployee.getEmployeeAddress());
		updatedResponse.setEmployeeMobileNo(updatedEmployee.getEmployeeMobileNo());
		updatedResponse.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
		updatedResponse.setEmployeeId(updatedEmployee.getEmployeeId());

		return updatedResponse;
	}

	@Override
	public List<AddingEmployeeResponseDto> getAllemployees() {
	
		List<Employee> employees=employeeRepository.findAll();
		
		if(employees.isEmpty()) {
			
			throw new EntityNotFoundException("601","No employees Found");
		}
		List<AddingEmployeeResponseDto> employeeResponse=employees.stream().map(response -> modelMapper.map(response, AddingEmployeeResponseDto.class)).collect(Collectors.toList());
		
		return employeeResponse;
	}
@Override
	public OrderResponseWithSprinterDTO getOrderDetailsWithSprinter(Long orderId) {
		
		System.out.println("RestTemplate Call");
		
		OrderResponseWithSprinterDTO forObject = restTemplate.getForObject(url+orderId, OrderResponseWithSprinterDTO.class);
		return forObject;
	}


}
