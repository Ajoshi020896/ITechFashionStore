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
public class UpdatedEmployeeResponseDTO {

	private long employeeId;

	private String employeeEmail;

	private String employeeName;

	private Date updatedDate;

	private long employeeMobileNo;

	private String employeeAddress;

}
