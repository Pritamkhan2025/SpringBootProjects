package com.anudip.sms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
	
	@Id
	private int cid;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please enter your course name")
	private String courseName;
	
	@Column(length = 5, nullable = false)
	@NotNull(message = "please enter your course fee")
	private double fee;
	
	@Column(length = 3, nullable = false)
	@NotNull(message = "please enter your course duration as integer")
	private int courseDuration;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "course", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Student> student;
	
}
