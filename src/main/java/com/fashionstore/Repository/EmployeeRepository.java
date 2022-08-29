package com.fashionstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionstore.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	Employee findByEmployeeEmailAndEmployeePassword(String employeeEmail, String employeePassword);

}
