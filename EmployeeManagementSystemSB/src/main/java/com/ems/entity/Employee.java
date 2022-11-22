package com.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	private int eid;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please Enter your firstname")
	@Size(min = 3, message = "name should have atleast 3 characters")
	private String ename;
	
	
	@Min(value=18, message = "Age should not be less than 18")
	@Max(value=70, message = "Age should not be greater than 70")
	@Column(length = 2, nullable = false)
	@NotNull(message = "please Enter your age")
	private int age;
	
	@Column(length = 6, nullable = false)
	@Size(min = 4, message = "gender should be male/female/other")
	@NotBlank(message = "please Enter your gender")
	private String gender;
	
	@Column(length = 30, nullable = false, unique = true)
	@NotBlank(message = "please Enter your email id")
	@Email
	private String email;
	
	//@Pattern(regexp = "^[6-9]\\d{9}$")
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please Enter your phone number")
	private long phone;
	
	@Column(length = 10, nullable = false)
	@NotNull(message = "please Enter your salary")
	private double salary;
	
	@Column(length = 50, nullable = false)
	@Size(min = 4, message = "address should have atleast 4 characters")
	@NotBlank(message = "please Enter your address")
	private String address;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please Enter your skill")
	private String skill;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="departmentid", referencedColumnName = "did")
	@JsonBackReference
	private Department department;
	
}
