package com.fashionstore.DTO;

import javax.persistence.Column;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerLoginRequestDTO {

	private String managerEmail;
	private String managerPassword;

}
