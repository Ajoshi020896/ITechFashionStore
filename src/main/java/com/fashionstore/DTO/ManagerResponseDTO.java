package com.fashionstore.DTO;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponseDTO {

	private long managerId;

	private String managerEmail;

	private String managerName;

	private String managerAddress;

	private long managerMobileNo;

}
