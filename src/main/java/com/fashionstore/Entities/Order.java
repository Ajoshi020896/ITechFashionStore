package com.fashionstore.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_tbl")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "order_type")
	private String orderType;

	@Column(name = "order_status")
	private OrderStatus orderStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date")
	private Date orderDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_date")
	private Date delieveryDate;

	@Column(name = "delievery_by")
	private String delieveryBy;
	
	@OneToOne(targetEntity = Customer.class ,cascade = CascadeType.ALL)
	private Customer customer;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Product> products;

	@ManyToOne(cascade = CascadeType.ALL)
	private Sprinter sprinter;

}
