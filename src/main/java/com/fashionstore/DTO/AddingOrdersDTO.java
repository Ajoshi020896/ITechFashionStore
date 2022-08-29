package com.fashionstore.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fashionstore.Entities.Customer;
import com.fashionstore.Entities.Product;
import com.fashionstore.Entities.Sprinter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddingOrdersDTO {

	private String orderType;
	private Long customerId;
	private List<Product> products;
	private Long sprinterId;

}
