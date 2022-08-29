package com.fashionstore.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_size")
	private int productSize;
	
	@Column(name="product_prize")
	private Long productPrice;
	
	@Column(name = "product_category")
	private String productCategory;

	//@ManyToMany(targetEntity = Customer.class)	
	//private List<Customer> customers;


	
	
	

}
