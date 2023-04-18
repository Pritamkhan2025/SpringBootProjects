package com.anudip.sms.entity;



import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	@Size(min = 3, message = "name should have atleast 3 characters")
	@Column(length = 15, nullable = false)
	@NotBlank(message = "please enter your firstname")
	private String fname;
	
	@Size(min = 2, message = "name should have atleast 2 characters")
	@Column(length = 12, nullable = false)
	@NotBlank(message = "please enter your lastname")
	private String lname;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date_of_birth", nullable = false)
	@NotBlank(message = "please enter your date of birth in given format")
	private LocalDate dateOfBirth;
	
	@Column(length = 6, nullable = false)
	@Size(min = 4, message = "gender should be male/female/other")
	@NotBlank(message = "please Enter your gender")
	private String gender;
	
	@Column(length = 15, nullable = false)
	@NotBlank(message = "please enter your stream you are pursuring")
	private String stream;
	
	@Column(length = 30, nullable = false, unique = true)
	@NotBlank(message = "please enter your email id")
	@Email
	private String email;
	
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please enter your phone number")
	private long phone;
	
	@Column(length = 50, nullable = false)
	@Size(min = 4, message = "address should have atleast 4 characters")
	@NotBlank(message = "please Enter your address")
	private String address;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="courseid", referencedColumnName = "cid")
	@JsonBackReference
	private Course course;

}
