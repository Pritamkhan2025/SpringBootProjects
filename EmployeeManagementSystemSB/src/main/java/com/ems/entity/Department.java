package com.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	@Id
	private int did;
	
	@Column(length = 20, nullable = false)
	@Size(min = 2, message = "name should have atleast 3 characters")
	@NotBlank(message = "please Enter your department name")
	private String dname;
	
	@Column(length = 20, nullable = false)
	@Size(min = 3, message = "manager name should have atleast 3 characters")
	@NotBlank(message = "please Enter your department manager name")
	private String manager;
	
	//@Pattern(regexp = "^[6-9]\\d{9}$")
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please Enter department phone number")
	private long dphone;
	
	@Column(length = 20, nullable = false)
	@Size(min = 3, message = "city should have atleast 3 characters")
	@NotBlank(message = "please Enter your department city")
	private String dcity;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Employee> employee;
	
}
