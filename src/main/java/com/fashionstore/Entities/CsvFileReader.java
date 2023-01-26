package com.fashionstore.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="csv_reader")
@Entity
public class CsvFileReader {
	
	@Id
	@Column(name="user_id")
	private String id;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_surname")
	private String surname;
	
	@Column(name="user_age")
	private String age;
	
	@Column(name="user_profession")
	private String profession;

}
