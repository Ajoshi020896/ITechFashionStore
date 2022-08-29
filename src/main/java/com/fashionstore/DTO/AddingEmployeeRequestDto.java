package com.fashionstore.DTO;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddingEmployeeRequestDto {

	private String employeeEmail;

	private String employeePassword;

	private String employeeName;

	private long employeeMobileNo;

	private String employeeAddress;

}
