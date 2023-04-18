package com.pms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "please Enter product name")
	private String pname;
	
	@Column(length = 25, nullable = false)
	@NotBlank(message = "please Enter product name")
	private String pbrand;
	
	@Column(length = 15, nullable = false)
	@NotNull(message = "please Enter price")
	private long price;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "oid", referencedColumnName = "oid")
	@JsonBackReference
	private Order order;

}
