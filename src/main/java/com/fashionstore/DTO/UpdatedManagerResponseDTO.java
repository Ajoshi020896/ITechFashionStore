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
public class UpdatedManagerResponseDTO {

	private long managerId;

	private String managerEmail;

	private String managerName;

	private String managerAddress;

	private long managerMobileNo;

	private Date updateDate;

}
